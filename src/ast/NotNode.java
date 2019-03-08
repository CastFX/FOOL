package ast;

import lib.FOOLlib;

public class NotNode implements Node {

  private Node exp;
  
  public NotNode (Node e) {
   exp=e;
  }
  
  public String toPrint(String s) {
   return s+"NOT\n" + exp.toPrint(s+"  ") ;
  }

  public Node typeCheck() {
	  Node expCheck = exp.typeCheck();
	  if (!(expCheck instanceof BoolTypeNode)){ 
			System.out.println("Incompatible types for NOT");
		    System.exit(0);
		}
	  return expCheck;
  }
      
  public String codeGeneration() {
	  String l1= FOOLlib.freshLabel();
	  String l2= FOOLlib.freshLabel();
	  
	  return exp.codeGeneration()+
			 "push 1\n"+
			 "beq "+l1+ "\n"+
			 "push 1\n"+
			 "b "+l2+"\n"+
		     l1+": \n"+
			 "push 0\n"+
			 l2+": \n"
	 ;
  }

}  