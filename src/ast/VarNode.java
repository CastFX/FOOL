package ast;

import lib.FOOLlib;

public class VarNode implements Node, DecNode {

    private String id;
    private Node type;
    private Node exp;

    public VarNode(String i, Node t, Node v) {
        id = i;
        type = t;
        exp = v;
    }

    public String toPrint(String s) {
        return s + "Var:" + id + "\n" + type.toPrint(s + "  ") + exp.toPrint(s + "  ");
    }

    public Node typeCheck() {
    	//Contenuto dell'exp deve essere sottotipo del tipo della variabile
        if (!FOOLlib.isSubtype(exp.typeCheck(), type)) {
            System.out.println("Incompatible value for variable: " + id + "\nexp:" + exp.typeCheck().toPrint(" ") +  ", type:" + type.toPrint(" "));
            System.exit(0);
        }
        return null;
    }

    public String codeGeneration() {
    	return exp.codeGeneration();
    }

    //HIGH ORDER
    @Override
    public Node getSymType() {
        return type;
    }

}