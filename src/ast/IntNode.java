package ast;
public class IntNode implements Node {

  private Integer val;
  
  public IntNode (Integer n) {
   val=n;
  }
  
  public String toPrint(String s) {
   return s+"Int:" + Integer.toString(val) +"\n";  
  }

  public Node typeCheck() {
	return new IntTypeNode(); 
  }
  
  public String codeGeneration() {
	  return "push "+val+"\n";
  }

}  