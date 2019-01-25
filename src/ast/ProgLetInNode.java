package ast;
import java.util.ArrayList;

import lib.FOOLlib;

public class ProgLetInNode implements Node {

  private ArrayList<Node> declist;
  private Node exp;
  
  public ProgLetInNode (ArrayList<Node> d, Node e) {
   declist=d;
   exp=e;
  }
  
  public String toPrint(String s) {
	 String declstr="";
	 for (Node dec:declist){declstr+=dec.toPrint(s+"  ");};
     return s+"ProgLetIn\n" + declstr + exp.toPrint(s+"  ") ; 
  }

  public Node typeCheck() {
    for (Node dec:declist){dec.typeCheck();};
    return exp.typeCheck();
  }
    
  public String codeGeneration() {
	  String declCode="";
	  for (Node dec:declist) declCode+=dec.codeGeneration();
	  return  "push 0\n"+
			  declCode+
			  exp.codeGeneration()+
			  "halt\n"+
			  FOOLlib.getCode();
  }

}  