grammar FOOL;

@header{
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import ast.*;
import lib.FOOLlib;
import lib.FOOLParsingLib;
}

@parser::members{
private int nestingLevel = 0;
private int offset_0 = -2;
private ArrayList<HashMap<String,STentry>> symTable = new ArrayList<HashMap<String,STentry>>();
private HashMap<String, HashMap<String, STentry>> classTable = new HashMap<>();
//livello ambiente con dichiarazioni piu' esterno � 0 (prima posizione ArrayList) invece che 1 (slides)
//il "fronte" della lista di tabelle � symTable.get(nestingLevel)
}

@lexer::members {
int lexicalErrors=0;
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

prog returns [Node ast]
	: {HashMap<String,STentry> hm = new HashMap<String,STentry> ();
       symTable.add(hm);
       boolean cl = false;
       boolean dec = false;}          
	  ( e=exp 	
        {$ast = new ProgNode($e.ast);} 
      | LET ( c=cllist {cl=true;}
      	(d=declist {dec=true;})? | d=declist {dec=true;}
      ) IN e=exp  {
			$ast = new ProgLetInNode(cl ? $c.astlist : new ArrayList<Node>(),
        		dec ? $d.astlist : new ArrayList<Node>(),$e.ast); }      
	  ) 
	  {symTable.remove(nestingLevel);}
      SEMIC ;
     
     
      
cllist returns [ArrayList<Node> astlist]      
	: {$astlist = new ArrayList<Node>();}
	( CLASS i=ID {
		ClassTypeNode ctn = new ClassTypeNode(new ArrayList<Node>(), new ArrayList<Node>());
        HashMap<String,STentry> virtualTable = new HashMap<String,STentry> ();
		HashSet<String> names = new HashSet<String>();
		STentry superEntry = null;
		String superId = "";
        STentry entry = new STentry(0, ctn, offset_0--);
		FOOLParsingLib.addClassToSymTable(symTable.get(0), $i.text, entry, $i.line);
        //NestingLevel = 1 Dentro la classe
        nestingLevel++;
        symTable.add(virtualTable);
        classTable.put($i.text, virtualTable);}
	(EXTENDS i2=ID {
		superId = $i2.text;
		FOOLParsingLib.ensureExtendedClassExists(symTable.get(0), $i2.text, $i2.line);
		HashMap<String, STentry> extVirtualTable = classTable.get($i2.text);
		for (String key : extVirtualTable.keySet()) {
			virtualTable.put(key, extVirtualTable.get(key).deepCopy());
		}
		superEntry = symTable.get(0).get($i2.text); 
		FOOLParsingLib.ensureExtendedSTentryType(superEntry, $i2.text, $i2.line);
		ClassTypeNode superCtn = (ClassTypeNode) superEntry.getType();
		ArrayList<Node> fieldTypes = superCtn.getAllFields();
		for (int i = 0; i < fieldTypes.size(); i++) {
			ctn.insertFieldType(fieldTypes.get(i),i);	
		}
		ArrayList<Node> methodTypes = superCtn.getAllMethods();
		for (int i = 0; i < methodTypes.size(); i++) {
			ctn.insertMethodType(methodTypes.get(i),i);	
		}}
	)? {
		ClassNode c = new ClassNode($i.text, ctn, superId, superEntry);
		FOOLlib.getSuperTypeMap().put($i.text, $i2.text);
		$astlist.add(c);}
	LPAR {
    	int fieldOffset = -ctn.getAllFields().size() - 1; } 
	( fid=ID COLON fty=type {
    	int thisFieldOffset = 0;
		FOOLParsingLib.ensureFieldNotOverridden(names, $fid.text, $fid.line);
		STentry oldSTentry = virtualTable.get($fid.text);
	    if (oldSTentry != null) { //Enable Field Override
	    	FOOLParsingLib.ensureFieldSTEntryNotMethod(oldSTentry, $fid.text, $fid.line);
	    	thisFieldOffset = oldSTentry.getOffset();
	    } else {
	    	thisFieldOffset = fieldOffset--;
	    }
    	FieldNode field = new FieldNode($fid.text, $fty.ast, thisFieldOffset);
    	c.addField(field);
    	ctn.insertFieldType($fty.ast, -thisFieldOffset - 1);
    	virtualTable.put($fid.text, new STentry(nestingLevel, $fty.ast, thisFieldOffset));}
	( COMMA id=ID COLON ty=type {
		FOOLParsingLib.ensureFieldNotOverridden(names, $id.text, $id.line);
		oldSTentry = virtualTable.get($id.text);
	    if (oldSTentry != null) { //Enable Field Override
	    	FOOLParsingLib.ensureFieldSTEntryNotMethod(oldSTentry, $id.text, $id.line);
	    	thisFieldOffset = oldSTentry.getOffset();
	    } else {
	    	thisFieldOffset = fieldOffset--;
	    }
    	field = new FieldNode($id.text, $ty.ast, thisFieldOffset);
    	c.addField(field);
    	ctn.insertFieldType($ty.ast, -thisFieldOffset - 1);
    	virtualTable.put($id.text, new STentry(nestingLevel, $ty.ast, thisFieldOffset));}
	)*
	)? 
	RPAR {}
	CLPAR { int methodOffset = ctn.getAllMethods().size(); }
	( FUN im=ID COLON tm=type {
		FOOLParsingLib.ensureMethodNotOverridden(names, $im.text, $im.line);
		int thisMethodOffset = 0;
    	STentry oldSTentry = virtualTable.get($im.text); //cerco una possibile entry già presente
	    if (oldSTentry != null) {
	    	FOOLParsingLib.ensureMethodSTentryIsMethod(oldSTentry, $im.text, $im.line);
	    	//Se presente nella virtual table ereditata allora faccio override di metodo (nuova STentry con vecchio offset)
    		thisMethodOffset = oldSTentry.getOffset();
	    } else { //Se non presente allora ne creo una nuova aumentando methodOffset
	    	thisMethodOffset = methodOffset++;
	    }
	    STentry newSTentry = new STentry(nestingLevel, $tm.ast, thisMethodOffset, true);
	    virtualTable.put($im.text, newSTentry); //infine aggiorno la virtualTable
		MethodNode m = new MethodNode($im.text, thisMethodOffset, $tm.ast, $tm.ast);
		c.addMethod(m); //aggiungo methodNode alla ClassNode
	    ctn.insertMethodType($tm.ast, thisMethodOffset);
        HashMap<String,STentry> hmn = new HashMap<String,STentry>();
        nestingLevel++; 
        symTable.add(hmn); }
	LPAR { 
		ArrayList<Node> parTypes = new ArrayList<Node>();
		int paroffset = 1; }
    ( fid=ID COLON fht=hotype { 
		parTypes.add($fht.ast);
		m.addPar(new ParNode($fid.text,$fht.ast));
		FOOLParsingLib.addParamSTentryToSymbolTable(hmn, $fid.text, nestingLevel, $fht.ast, paroffset++, $fid.line);}
	( COMMA id=ID COLON ht=hotype {
		parTypes.add($ht.ast);
		m.addPar(new ParNode($id.text,$ht.ast));
		FOOLParsingLib.addParamSTentryToSymbolTable(hmn, $id.text, nestingLevel, $ht.ast, paroffset++, $id.line);}
	)*
    )? 
	RPAR { newSTentry.addType(new ArrowTypeNode(parTypes,$tm.ast)); }
	( LET {
		ArrayList<Node> declist = new ArrayList<Node>();
		int fOffset = -2;
		m.addDec(declist);} 
	(VAR ci=ID COLON ct=type ASS ce=exp SEMIC { 
		declist.add(new VarNode($ci.text,$ct.ast,$ce.ast));
		//Controllo che nella Table del metodo non sia già stato dichiarato un campo/parametro uguale
		FOOLParsingLib.addVarSTentryToSymbolTable(hmn, $ci.text, nestingLevel, $ct.ast, fOffset--, $ci.line);}
	)+ IN)? be=exp { 
		m.addBody($be.ast);
		//Rimuovo la symbolTable(NL=2) dentro la declist di un metodo(NL=1) di una classe(NL=0)
		symTable.remove(nestingLevel--); }
	SEMIC )*
	CRPAR {
		//Esco dalla classe -> rimuovo VirtualTable e torno a NL=0 
		symTable.remove(nestingLevel--);} 
  	)+
	;

declist returns [ArrayList<Node> astlist]        
	: {$astlist= new ArrayList<Node>();
	   int offset=-2;}      
	( (VAR i=ID COLON ht=hotype ASS e=exp {
		VarNode v = new VarNode($i.text,$ht.ast,$e.ast);  
		$astlist.add(v);                                 
		HashMap<String,STentry> hm = symTable.get(nestingLevel);
		FOOLParsingLib.addVarSTentryToSymbolTable(hm, $i.text, nestingLevel, $ht.ast, 
			nestingLevel == 0 ? offset_0-- : offset--, $i.line);}
	| FUN i=ID COLON t=type {//inserimento di ID nella symtable
		FunNode f = new FunNode($i.text,$t.ast);      
		$astlist.add(f);                           
		HashMap<String,STentry> hm = symTable.get(nestingLevel);
		FOOLParsingLib.addFunSTentryToSymbolTable(hm, $i.text, nestingLevel, $t.ast, 
			nestingLevel == 0 ? offset_0-- : offset--, $i.line);
		STentry entry = hm.get($i.text);
		//creare una nuova hashmap per la symTable
		nestingLevel++;
		HashMap<String,STentry> hmn = new HashMap<String,STentry> ();
		symTable.add(hmn); }
	LPAR {
		ArrayList<Node> parTypes = new ArrayList<Node>();
		int paroffset=1; }
	(fid=ID COLON fht=hotype { 
		parTypes.add($fht.ast);
		f.addPar(new ParNode($fid.text,$fht.ast));
		FOOLParsingLib.addParamSTentryToSymbolTable(hmn, $fid.text, nestingLevel, $fht.ast, paroffset++, $fid.line);}
	(COMMA id=ID COLON ht=hotype {
		parTypes.add($ht.ast);
        f.addPar(new ParNode($id.text,$ht.ast));
		FOOLParsingLib.addParamSTentryToSymbolTable(hmn, $id.text, nestingLevel, $ht.ast, paroffset++, $id.line);}
	)*
	)? 
	RPAR { entry.addType(new ArrowTypeNode(parTypes,$t.ast)); }
	(LET d=declist IN {f.addDec($d.astlist);})? e=exp {
		f.addBody($e.ast);
        //rimuovere la hashmap corrente poich esco dallo scope               
        symTable.remove(nestingLevel--); }
	) SEMIC
    )+          
	;
	
hotype returns [Node ast] 
	: a=arrow {$ast = $a.ast;} | t=type {$ast = $t.ast;}
	;
	
type returns [Node ast]
	: INT  {$ast=new IntTypeNode();}
	| BOOL {$ast=new BoolTypeNode();} 
	| i=ID {$ast=new RefTypeNode($i.text);
	}
	;	

arrow returns [Node ast]
	: LPAR (hotype (COMMA hotype)* )? RPAR ARROW type {
		return null;
	};          


exp	returns [Node ast]
 	: f=term {$ast= $f.ast;} 
 		(PLUS l=term {$ast= new PlusNode ($ast,$l.ast);}
		| MINUS l=term {$ast = new MinusNode ($ast, $l.ast);}
		| OR l=term {$ast = new OrNode ($ast, $l.ast);}
 	    )*    
 	;
 	
term returns [Node ast]
	: f=factor {$ast= $f.ast;}
	    ( TIMES l=factor {$ast= new MultNode ($ast,$l.ast);}
		| DIV l=factor {$ast = new DivNode ($ast, $l.ast);}
		| AND l=factor {$ast = new AndNode ($ast, $l.ast);}
	    )*
	;

	
factor returns [Node ast]
	: f=value {$ast= $f.ast;}
	    ( EQ l=value {$ast= new EqualNode ($ast,$l.ast);}
     	| GE l=value {$ast = new GreaterEqualNode ($ast, $l.ast);}
		| LE l=value {$ast = new LesserEqualNode ($ast, $l.ast);}
	    )*
 	;
	 	
 
value returns [Node ast]
	: n=INTEGER   
		{$ast = new IntNode(Integer.parseInt($n.text));}  
	| TRUE 
		{$ast = new BoolNode(true);}  
	| FALSE
		{$ast = new BoolNode(false);}  
	| NOT LPAR e=exp RPAR
	  {$ast= new NotNode($e.ast);}
	| NULL 
		{$ast = new EmptyNode();}
	| NEW i=ID LPAR {
		ArrayList<Node> parlist = new ArrayList<>();
		FOOLParsingLib.ensureNewNodeSTentryIsPresent(symTable.get(0), $i.text, $i.line);
		STentry entry = symTable.get(0).get($i.text);
		$ast = new NewNode($i.text, entry, parlist, nestingLevel);}
	(fe=exp { parlist.add($fe.ast); }
	(COMMA e=exp { parlist.add($e.ast); } )* 
	)? RPAR
	| IF x=exp THEN CLPAR y=exp CRPAR 
		   ELSE CLPAR z=exp CRPAR 
		{$ast= new IfNode($x.ast,$y.ast,$z.ast);}	 
	| NOT LPAR exp RPAR {}
	| PRINT LPAR e=exp RPAR	
		{$ast= new PrintNode($e.ast);}
  	| LPAR e=exp RPAR
		{$ast= $e.ast;}  
	| i=ID {
		STentry entry = FOOLParsingLib.getIDFromSymbolTable(symTable, $i.text, nestingLevel, $i.line);       
		$ast= new IdNode($i.text,entry,nestingLevel);} 
	( LPAR {
		ArrayList<Node> arglist = new ArrayList<Node>(); } 
	( a=exp {arglist.add($a.ast);} 
	(COMMA a=exp {arglist.add($a.ast);} )*
	)? 
	RPAR {$ast= new CallNode($i.text,entry,arglist,nestingLevel);} 
	| DOT mi=ID LPAR {
		ArrayList<Node> parlist = new ArrayList<>();
		FOOLParsingLib.ensureIDIsRefTypeNode(entry, $i.text, $mi.line);
		RefTypeNode rtn = (RefTypeNode) entry.getType();
        STentry methodEntry = null;
        FOOLParsingLib.ensureClassTableContainsMethod(classTable.get(rtn.getId()), $mi.text, $mi.line);
        methodEntry = classTable.get(rtn.getId()).get($mi.text);
        $ast = new ClassCallNode($mi.text, entry, methodEntry, parlist, nestingLevel);}	
	( fe=exp { parlist.add($fe.ast);}
	(COMMA e=exp { parlist.add($e.ast); } 
	)* 
	)? RPAR )?
 	; 

/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/

PLUS  	: '+' ;
MINUS   : '-' ;
TIMES   : '*' ;
DIV 	: '/' ;
LPAR	: '(' ;
RPAR	: ')' ;
CLPAR	: '{' ;
CRPAR	: '}' ;
SEMIC 	: ';' ;
COLON   : ':' ; 
COMMA	: ',' ;
DOT	    : '.' ;
OR	    : '||';
AND	    : '&&';
NOT	    : '!' ;
GE	    : '>=' ;
LE	    : '<=' ;
EQ	    : '==' ;	
ASS	    : '=' ;
TRUE	: 'true' ;
FALSE	: 'false' ;
IF	    : 'if' ;
THEN	: 'then';
ELSE	: 'else' ;
PRINT	: 'print' ;
LET     : 'let' ;	
IN      : 'in' ;	
VAR     : 'var' ;
FUN	    : 'fun' ; 
CLASS	: 'class' ; 
EXTENDS : 'extends' ;	
NEW 	: 'new' ;	
NULL    : 'null' ;	  
INT	    : 'int' ;
BOOL	: 'bool' ;
ARROW   : '->' ; 	
INTEGER : '0' | ('-')?(('1'..'9')('0'..'9')*) ; 

ID  	: ('a'..'z'|'A'..'Z')('a'..'z' | 'A'..'Z' | '0'..'9')* ;


WHITESP  : ( '\t' | ' ' | '\r' | '\n' )+    -> channel(HIDDEN) ;

COMMENT : '/*' (.)*? '*/' -> channel(HIDDEN) ;
 
ERR   	 : . { System.out.println("Invalid char: "+ getText()); lexicalErrors++; } -> channel(HIDDEN); 
