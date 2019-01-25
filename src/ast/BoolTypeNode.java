package ast;
public class BoolTypeNode implements Node {
  
  public BoolTypeNode () {
  }
  
  public String toPrint(String s) {
   return s+"BoolType\n";  
  }
  
  //non utilizzato
  public Node typeCheck() {return null;}
 
  //non utilizzato
  public String codeGeneration() {return "";}

}  