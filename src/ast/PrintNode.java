package ast;
public class PrintNode implements Node {

  private Node exp;
  
  public PrintNode (Node e) {
   exp=e;
  }
  
  public String toPrint(String s) {
   return s+"Print\n" + exp.toPrint(s+"  ") ;
  }

  public Node typeCheck() {
	    return exp.typeCheck();
  }
      
  public String codeGeneration() {
	  return exp.codeGeneration()+
			 "print\n";
  }

}  