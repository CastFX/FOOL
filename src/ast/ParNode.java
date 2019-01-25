package ast;
public class ParNode implements Node {

  private String id;
  private Node type;
  
  public ParNode (String i, Node t) {
   id=i;
   type=t;
  }
  
  public String toPrint(String s) {
	   return s+"Par:" + id +"\n"
			   +type.toPrint(s+"  ") ; 
  }

  //non utilizzato
  public Node typeCheck() {return null;}
   
  public String codeGeneration() {return "";}

}  