package ast;

import java.util.ArrayList;

import lib.FOOLlib;

public class MethodNode implements Node, DecNode {

    private String id;
    private Node type;
    private ArrayList<Node> parlist = new ArrayList<Node>();
    private ArrayList<Node> declist = new ArrayList<Node>();
    private Node exp;
    private Node symType;

    public MethodNode(String i, Node t) {
        id = i;
        type = t;
    }

    public void addDec(ArrayList<Node> d) {
        declist = d;
    }

    public void addBody(Node b) {
        exp = b;
    }

    public void addPar(Node p) { // metodo "addPar" che aggiunge un nodo a campo
        parlist.add(p);
    }

    @Override
    public String toPrint(String indent) {
        String parlstr = "";
        for (Node par : parlist) {
            parlstr += par.toPrint(indent + "  ");
        }
        ;
        String declstr = "";
        for (Node dec : declist) {
            declstr += dec.toPrint(indent + "  ");
        }
        ;
        return indent 
                + "M_Fun:" + id + "\n" 
                + type.toPrint(indent + "  ") 
                + parlstr 
                + declstr 
                + exp.toPrint(indent + "  ");
    }

    @Override
    public Node typeCheck() {
        for (Node dec : declist) {
            dec.typeCheck();
        }
        ;
        if (!FOOLlib.isSubtype(exp.typeCheck(), type)) {
            System.out.println("Incompatible value for variable");
            System.exit(0);
        }
        return null;
    }

    @Override
    public String codeGeneration() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Node getSymType() {
        return symType;
    }
}
