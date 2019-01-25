grammar SVM;

@header {
import java.util.HashMap;
}

@lexer::members {
int lexicalErrors=0;
}

@parser::members {
      
    int[] code = new int[ExecuteVM.CODESIZE];    
    private int i = 0;
    private HashMap<String,Integer> labelAdd = new HashMap<String,Integer>();
    private HashMap<Integer,String> labelRef = new HashMap<Integer,String>();
        
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/
  
assembly: 
    ( PUSH n=NUMBER   {code[i++] = PUSH; 
			                 code[i++] = Integer.parseInt($n.text);}
	  | PUSH l=LABEL    {code[i++] = PUSH; //
	    		             labelRef.put(i++,$l.text);} 		     
	  | POP		    {code[i++] = POP;}	
	  | ADD		    {code[i++] = ADD;}
	  | SUB		    {code[i++] = SUB;}
	  | MULT	    {code[i++] = MULT;}
	  | DIV		    {code[i++] = DIV;}
	  | STOREW	  {code[i++] = STOREW;} //
	  | LOADW           {code[i++] = LOADW;} //
	  | l=LABEL COL     {labelAdd.put($l.text,i);}
	  | BRANCH l=LABEL  {code[i++] = BRANCH;
                       labelRef.put(i++,$l.text);}
	  | BRANCHEQ l=LABEL {code[i++] = BRANCHEQ; //
                        labelRef.put(i++,$l.text);}
	  | BRANCHLESSEQ l=LABEL {code[i++] = BRANCHLESSEQ;
                          labelRef.put(i++,$l.text);}
	  | JS              {code[i++] = JS;}		     //
	  | LOADRA          {code[i++] = LOADRA;}    //
	  | STORERA         {code[i++] = STORERA;}   //
	  | LOADRV          {code[i++] = LOADRV;}   //
	  | STORERV         {code[i++] = STORERV;}    //
	  | LOADFP          {code[i++] = LOADFP;}   //
	  | STOREFP         {code[i++] = STOREFP;}   //
	  | COPYFP          {code[i++] = COPYFP;}   //
	  | LOADHP          {code[i++] = LOADHP;}   //
	  | STOREHP         {code[i++] = STOREHP;}   //
	  | PRINT           {code[i++] = PRINT;}
	  | HALT            {code[i++] = HALT;}
	  )* { for (Integer refAdd: labelRef.keySet()) {
	              code[refAdd]=labelAdd.get(labelRef.get(refAdd));
		     } 
		   } ;


/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/

PUSH	 : 'push' ; 	
POP	 : 'pop' ; 	
ADD	 : 'add' ;  	
SUB	 : 'sub' ;	
MULT	 : 'mult' ;  	
DIV	 : 'div' ;	
STOREW	 : 'sw' ; 	
LOADW	 : 'lw' ;	
BRANCH	 : 'b' ;	
BRANCHEQ : 'beq' ;	
BRANCHLESSEQ:'bleq' ;	
JS	 : 'js' ;	
LOADRA	 : 'lra' ;	
STORERA  : 'sra' ;	 
LOADRV	 : 'lrv' ;	
STORERV  : 'srv' ;	
LOADFP	 : 'lfp' ;	
STOREFP	 : 'sfp' ;	
COPYFP   : 'cfp' ;      
LOADHP	 : 'lhp' ;	
STOREHP	 : 'shp' ;	
PRINT	 : 'print' ;	
HALT	 : 'halt' ;	
 
COL	 : ':' ;
LABEL	 : ('a'..'z'|'A'..'Z')('a'..'z' | 'A'..'Z' | '0'..'9')* ;
NUMBER	 : '0' | ('-')?(('1'..'9')('0'..'9')*) ;

WHITESP  : (' '|'\t'|'\n'|'\r')+ -> channel(HIDDEN) ;

ERR	     : . { System.out.println("Invalid char: "+ getText()); lexicalErrors++; } -> channel(HIDDEN); 

