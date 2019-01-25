package ast;
import java.util.ArrayList;

public class ProgNode implements Node {

  private Node exp;
  
  public ProgNode (Node e) {
   exp=e;
  }
  
  public String toPrint(String s) {
    
   return s+"Prog\n" + exp.toPrint(s+"  ") ;
  }
  
  public Node typeCheck() {
	    return exp.typeCheck();
  }
    
  public String codeGeneration() {
	  return exp.codeGeneration()+
			 "halt\n";
  }

}  