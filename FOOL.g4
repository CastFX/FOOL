grammar FOOL;

@header{
import java.util.ArrayList;
import java.util.HashMap;
import ast.*;
import lib.FOOLlib;
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
       symTable.add(hm);}          
	  ( e=exp 	
        {$ast = new ProgNode($e.ast);} 
      | LET ( c=cllist (d=declist) ? | d=declist) IN e=exp  
        {$ast = new ProgLetInNode($c.astlist,$d.astlist,$e.ast);}      
	  ) 
	  {symTable.remove(nestingLevel);}
      SEMIC ;
     
     
      
cllist returns [ArrayList<Node> astlist]      
	: {$astlist = new ArrayList<Node>();
		int offset = offset_0;}
	( CLASS i=ID {
		ClassTypeNode ctn = new ClassTypeNode(new ArrayList<Node>(), new ArrayList<Node>());
        HashMap<String,STentry> virtualTable = new HashMap<String,STentry> ();
		boolean extending = false;
		STentry superEntry = null;
		String superId = "";
	}
	(EXTENDS i2=ID {
		extending = true;
		superId = $i2.text;
		if (!symTable.get(0).containsKey($i2.text) || !classTable.containsKey($i2.text)) {
			System.out.println("Super class " + $i2.text + " at line: " + $i2.line + " does not exist");
			System.exit(0);
		}
		HashMap<String, STentry> extVirtualTable = classTable.get($i2.text);
		for (String key : extVirtualTable.keySet()) {
			virtualTable.put(key, extVirtualTable.get(key).deepCopy());
		}
		superEntry = symTable.get(0).get($i2.text); 
		if (!(superEntry.getType()  instanceof ClassTypeNode)) {
			System.out.println($i2.text + " extended at line: " + $i2.line +  "is not a class");
			System.exit(0);			
		}
		ClassTypeNode superCtn = (ClassTypeNode) superEntry.getType();
		ArrayList<Node> fieldTypes = superCtn.getAllFields();
		for (int i = 0; i < fieldTypes.size(); i++) {
			ctn.insertFieldType(fieldTypes.get(i),i);	
		}
		ArrayList<Node> methodTypes = superCtn.getAllMethods();
		for (int i = 0; i < methodTypes.size(); i++) {
			ctn.insertMethodType(methodTypes.get(i),i);	
		}

	}
		
	)? {
        if (extending) {
        	if (!classTable.containsKey($i2.text)) {
        		System.out.println("Super class " + $i2.text + " not present in classTable");
        		System.exit(0);
        	}
        	HashMap<String, STentry> exVirtualTable = classTable.get($i2.text);
        	for (String key : exVirtualTable.keySet()) {
        		virtualTable.put(key, exVirtualTable.get(key).deepCopy());
        	}
        }
        nestingLevel++;
        symTable.add(virtualTable);
        classTable.put($i.text, virtualTable);
        STentry entry = new STentry(0, ctn, offset--);
        if (symTable.get(0).put($i.text, entry) != null) { //niente override tra classi
        	System.out.println("Class id "+$i.text+" at line "+$i.line+" already declared");
            System.exit(0); 
        } 
		ClassNode c = new ClassNode($i.text, ctn, superId, superEntry);
		FOOLlib.getSuperTypeMap().put($i.text, $i2.text);
		$astlist.add(c);}
	LPAR { /*START_Fields*/
    	int fieldOffset = -1 - ctn.getAllFields().size(); } 
	( fid=ID COLON fty=type {
	    FieldNode ffield = new FieldNode($fid.text,$fty.ast);
	    c.addField(ffield);
	    ctn.insertFieldType($fty.ast, -fieldOffset - 1);
	    if (virtualTable.containsKey($fid.text)) { //Enable Field Override
	    	STentry oldSTentry = virtualTable.get($fid.text);
	    	if (oldSTentry.isMethod()){ //Disable Field Override from Method
	    		System.out.println("Field id "+$fid.text+" at line "+$fid.line+" already declared as method");
        		System.exit(0);
	    	} else {
		    	virtualTable.put($fid.text, new STentry(nestingLevel, $fty.ast, oldSTentry.getOffset()));
	    	}
	    } else {
	    	virtualTable.put($fid.text, new STentry(nestingLevel, $fty.ast, fieldOffset--));
	    } }
	( COMMA id=ID COLON ty=type {
    	FieldNode field = new FieldNode($id.text, $ty.ast);
    	c.addField(field);
	    ctn.insertFieldType($ty.ast, -fieldOffset - 1);
	    if (virtualTable.containsKey($id.text)) { //Enable Field Override
	    	STentry oldSTentry = virtualTable.get($id.text);
	    	if (oldSTentry.isMethod()){ //Disable Field Override from Method
	    		System.out.println("Field id "+$id.text+" at line "+$id.line+" already declared as method");
        		System.exit(0);
	    	} else {
		    	virtualTable.put($id.text, new STentry(nestingLevel, $ty.ast, oldSTentry.getOffset()));
	    	}
	    } else {
	    	virtualTable.put($id.text, new STentry(nestingLevel, $ty.ast, fieldOffset--));
	    } }
	)*
	)? 
	RPAR {} //END_Fields TODO secondo param ???
	CLPAR { int methodOffset = ctn.getAllMethods().size(); }
	( FUN im=ID COLON tm=type {
		//inserimento di ID nella symtable
		MethodNode m = new MethodNode($im.text,$tm.ast, $tm.ast);      
		c.addMethod(m);
	    ctn.insertMethodType($tm.ast, methodOffset);                            
	    STentry newSTentry = null;
	    if (virtualTable.containsKey($im.text)) { //Enable Method Override
	    	STentry oldSTentry = virtualTable.get($im.text);
	    	if (!oldSTentry.isMethod()){ //Disable Method Override from Field
	    		System.out.println("Field id "+$im.text+" at line "+$im.line+" already declared as method");
        		System.exit(0);
	    	} else {
	    		newSTentry = new STentry(nestingLevel, $tm.ast, oldSTentry.getOffset(), true);
	    	}
	    } else {
	    	newSTentry = new STentry(nestingLevel, $tm.ast, methodOffset++, true);
	    }
	    virtualTable.put($im.text, newSTentry);
        //TODO verificare creare una nuova hashmap per la symTable
        nestingLevel++;
        HashMap<String,STentry> hmn = new HashMap<String,STentry> ();
        symTable.add(hmn); }
	LPAR { 
		ArrayList<Node> parTypes = new ArrayList<Node>();
		int paroffset=1; }
    ( fid=ID COLON fht=hotype { 
		parTypes.add($fty.ast);
		ParNode fpar = new ParNode($fid.text,$fty.ast); //creo nodo ParNode
		m.addPar(fpar);                                 //lo attacco al FunNode con addPar
		if ( hmn.put($fid.text,new STentry(nestingLevel,$fty.ast,paroffset++)) != null  ) //aggiungo dich a hmn
		{ System.out.println("Parameter id "+$fid.text+" at line "+$fid.line+" already declared");
			System.exit(0); } }
	( COMMA id=ID COLON ht=hotype {
		parTypes.add($ty.ast);
		ParNode par = new ParNode($id.text,$ty.ast);
		m.addPar(par);
		if ( hmn.put($id.text,new STentry(nestingLevel,$ty.ast,paroffset++)) != null  )
		{ System.out.println("Parameter id "+$id.text+" at line "+$id.line+" already declared");
			System.exit(0); } }
	)*
    )? 
	RPAR {
		newSTentry.addType(new ArrowTypeNode(parTypes,$tm.ast));
	}
	( LET {
		ArrayList<Node> declist = new ArrayList<Node>();
		m.addDec(declist); } 
	(VAR ci=ID COLON ct=type ASS ce=exp SEMIC { 
		VarNode v = new VarNode($ci.text,$ct.ast,$ce.ast);
		declist.add(v);
		if ( hmn.put($ci.text, new STentry(nestingLevel,$ct.ast,offset--)) != null) {
			System.out.println("Var id "+$i.text+" at line "+$i.line+" already declared");
  			System.exit(0); } }
	)+ IN)? re=exp {
		m.addBody($re.ast);
		//rimuovere la hashmap corrente poich esco dallo scope*/               
		symTable.remove(nestingLevel--); }
	SEMIC )*
	CRPAR {
		symTable.remove(nestingLevel--);}
  	)+
	;
      

declist returns [ArrayList<Node> astlist]        
	: {$astlist= new ArrayList<Node>() ;
	   int offset=-2;}      
	( (VAR i=ID COLON ht=hotype ASS e=exp {
		VarNode v = new VarNode($i.text,$ht.ast,$e.ast);  
		$astlist.add(v);                                 
		HashMap<String,STentry> hm = symTable.get(nestingLevel);
		if ( hm.put($i.text,new STentry(nestingLevel,$ht.ast,nestingLevel == 0 ? offset_0-- : offset--)) != null  )
		{
			System.out.println("Var id "+$i.text+" at line "+$i.line+" already declared");
              System.exit(0); } }  
	| FUN i=ID COLON t=type {//inserimento di ID nella symtable
		FunNode f = new FunNode($i.text,$t.ast);      
		$astlist.add(f);                           
		HashMap<String,STentry> hm = symTable.get(nestingLevel);
		STentry entry = new STentry(nestingLevel, nestingLevel == 0 ? offset_0-- : offset--);
		if ( hm.put($i.text,entry) != null  ) {
			System.out.println("Fun id "+$i.text+" at line "+$i.line+" already declared");
			System.exit(0); }
		//creare una nuova hashmap per la symTable
		nestingLevel++;
		HashMap<String,STentry> hmn = new HashMap<String,STentry> ();
		symTable.add(hmn); }
	LPAR {
		ArrayList<Node> parTypes = new ArrayList<Node>();
		int paroffset=1; }
	(fid=ID COLON fty=hotype { 
		parTypes.add($fty.ast);
		ParNode fpar = new ParNode($fid.text,$fty.ast); //creo nodo ParNode
		f.addPar(fpar);                                 //lo attacco al FunNode con addPar
        if ( hmn.put($fid.text,new STentry(nestingLevel,$fty.ast,paroffset++)) != null  ) //aggiungo dich a hmn
        { System.out.println("Parameter id "+$fid.text+" at line "+$fid.line+" already declared");
        	System.exit(0);} }
	(COMMA id=ID COLON ty=hotype {
		parTypes.add($ty.ast);
		ParNode par = new ParNode($id.text,$ty.ast);
        f.addPar(par);
        if ( hmn.put($id.text,new STentry(nestingLevel,$ty.ast,paroffset++)) != null  )
        { System.out.println("Parameter id "+$id.text+" at line "+$id.line+" already declared");
        	System.exit(0);} }
	)*
	)? 
	RPAR {
		entry.addType(new ArrowTypeNode(parTypes,$t.ast)); }
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
	(PLUS l=term {
		$ast= new PlusNode ($ast,$l.ast); }
	)*
 	;
 	
term returns [Node ast]
	: f=factor {$ast= $f.ast;}
	    (TIMES l=factor
	     {$ast= new MultNode ($ast,$l.ast);}
	    )*
	;
	
factor	returns [Node ast]
	: f=value {$ast = $f.ast;}
      (EQ l=value 
	     {$ast= new EqualNode ($ast,$l.ast);}
    	)*
 	;	 	
 
value	returns [Node ast]
	: n=INTEGER   
		{$ast = new IntNode(Integer.parseInt($n.text));}  
	| TRUE 
		{$ast = new BoolNode(true);}  
	| FALSE
		{$ast = new BoolNode(false);}  
	| NULL 
		{$ast = new EmptyNode();}
	| NEW i=ID LPAR {
		ArrayList<Node> parlist = new ArrayList<>();
		STentry entry = symTable.get(0).get($i.text);
		if (entry == null) {
			System.out.println("Id "+$i.text+" at line "+$i.line+" not declared");
            System.exit(0);
        }
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
	| i=ID {//cercare la dichiarazione
		int j=nestingLevel;
		STentry entry=null; 
		while (j>=0 && entry==null)
			entry=(symTable.get(j--)).get($i.text);
		if (entry==null) {
			System.out.println("Id "+$i.text+" at line "+$i.line+" not declared");
            System.exit(0);}               
		$ast= new IdNode($i.text,entry,nestingLevel);} 
	( LPAR {
		ArrayList<Node> arglist = new ArrayList<Node>(); } 
	( a=exp {arglist.add($a.ast);} 
	(COMMA a=exp {arglist.add($a.ast);} )*
	)? 
	RPAR {$ast= new CallNode($i.text,entry,arglist,nestingLevel);} 
	| DOT mi=ID LPAR {
		ArrayList<Node> parlist = new ArrayList<>();
		if (!(entry.getType() instanceof RefTypeNode)) {
			System.out.println("ID " + $i.text + " not instance of RefTypeNode at line " + $mi.line);
			System.exit(0);
		}
		RefTypeNode rtn = (RefTypeNode) entry.getType();
        STentry methodEntry = null;
        if (!classTable.get(rtn.getId()).containsKey($mi.text)) {
			System.out.println("Method Id "+$i.text+" at line "+$i.line+" not declared");
            System.exit(0);
        }
        methodEntry = classTable.get(rtn.getId()).get($mi.text);
        $ast = new ClassCallNode($mi.text, entry, methodEntry, parlist, nestingLevel);}	
	( fe=exp { parlist.add($fe.ast);}
	(COMMA e=exp)* {parlist.add($e.ast);} 
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
