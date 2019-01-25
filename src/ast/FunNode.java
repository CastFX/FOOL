package ast;
import java.util.ArrayList;

import lib.FOOLlib;

public class FunNode implements Node {

  private String id;
  private Node type; 
  private ArrayList<Node> parlist = new ArrayList<Node>(); // campo "parlist" che è lista di Node
  private ArrayList<Node> declist = new ArrayList<Node>(); 
  private Node exp;
  
  public FunNode (String i, Node t) {
   id=i;
   type=t;
  }
  
  public void addDec (ArrayList<Node> d) {
    declist=d;
  }  

  public void addBody (Node b) {
	exp=b;
  }  

  public void addPar (Node p) { //metodo "addPar" che aggiunge un nodo a campo "parlist"
   parlist.add(p);  
  }  
  
  public String toPrint(String s) {
		 String parlstr="";
		 for (Node par:parlist){parlstr+=par.toPrint(s+"  ");};
		 String declstr="";
		 for (Node dec:declist){declstr+=dec.toPrint(s+"  ");};
	   return s+"Fun:" + id +"\n"
			   +type.toPrint(s+"  ")
			   +parlstr
			   +declstr
               +exp.toPrint(s+"  ") ; 
  }
  
  public Node typeCheck() {
	  for (Node dec:declist){dec.typeCheck();};
      if (! FOOLlib.isSubtype(exp.typeCheck(),type)) {
			  System.out.println("Incompatible value for variable");
			  System.exit(0);
	  }
      return null;
  }
	     
  public String codeGeneration() {
	  String declCode="";
	  for (Node dec:declist) declCode+=dec.codeGeneration();
	  
	  String popDecl="";
	  for (Node dec:declist) popDecl+="pop\n";
	  
	  String popParl="";
	  for (Node par:parlist) popParl+="pop\n";
	  
	  
	  String funl=FOOLlib.freshFunLabel();
	  
	  FOOLlib.putCode(funl+":\n"+
	          "cfp\n"+ //setta $fp a $sp
			  "lra\n"+ //inserisce return address
			  declCode+ //inresisce dichiarazioni locali
			  exp.codeGeneration()+
			  "srv\n"+ //pop del return value
			  popDecl+ //pop delle dichiarazioni
			  "sra\n"+   //pop del return address 
			  "pop\n"+   //pop di AL
			  popParl+  //pop dei parametri
			  "sfp\n"+   //setto $fp al valore del CL
			  "lrv\n"+  // risultato della funzione sullo stack
			  "lra\n"+"js\n" //salta a $ra
			  );
	  
	  return "push "+ funl + "\n";
  }

}  