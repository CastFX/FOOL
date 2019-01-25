package ast;

import lib.*;

public class MultNode implements Node {

  private Node left;
  private Node right;
  
  public MultNode (Node l, Node r) {
   left=l;
   right=r;
  }
  
  public String toPrint(String s) {
   return s+"Mult\n" + left.toPrint(s+"  ")  
                     + right.toPrint(s+"  ") ; 
  }

  public Node typeCheck() {
   if ( ! ( FOOLlib.isSubtype(left.typeCheck(), new IntTypeNode()) &&
		    FOOLlib.isSubtype(right.typeCheck(), new IntTypeNode()) ) ) {
			  System.out.println("Non integers in multiplication");
			  System.exit(0);	
   }
   return new IntTypeNode();
  }
  
  public String codeGeneration() {
	  return left.codeGeneration()+right.codeGeneration()+"mult\n";
  }

}  