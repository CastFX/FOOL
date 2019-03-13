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
    private String label;
    private int offset;
    
    public MethodNode(String i, int off, Node t, Node st) {
        id = i;
        offset = off;
        type = t;
        symType = st;
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
        String declstr = "";
        for (Node dec : declist) {
            declstr += dec.toPrint(indent + "  ");
        }
        ;
        return indent 
                + "Method:" + id + "\n" 
                + type.toPrint(indent + "  ") 
                + parlstr 
                + declstr 
                + exp.toPrint(indent + "  ");
    }

    @Override
    public Node typeCheck() {
    	//Typecheck di tutte le variabili dichiarate dentro il metodo (secondo la grammatica non si possono dichiarare 
    	//sotto-funzioni
        for (Node dec : declist) {
            dec.typeCheck();
        }
        if (!FOOLlib.isSubtype(exp.typeCheck(), type)) {
            System.out.println("Incompatible value for variable in method");
            System.exit(0);
        }
        return null;
    }

    @Override
    public String codeGeneration() {
        label = FOOLlib.freshFunLabel();
        String declCode = "";
        for (Node dec : declist) //Genero il codice delle variabili dichiarate dentro il metodo
            declCode += dec.codeGeneration();
        String popDecl = ""; 
        for (Node dec : declist) //E poi dovrò rimuoverle
            popDecl += "pop\n";
        String popParl = "";
        for (Node par : parlist) //Poi devo anche rimuovere i parametri
            popParl += "pop\n";
        FOOLlib.putCode(label + ":\n" + 
                "cfp\n" + // setta $fp a $sp
                "lra\n" + // inserisce return address
                declCode + // inresisce dichiarazioni locali
                exp.codeGeneration() + "srv\n" + // pop del return value
                popDecl + // pop delle dichiarazioni
                "sra\n" + // pop del return address
                "pop\n" + // pop di AL
                popParl + // pop dei parametri
                "sfp\n" + // setto $fp al valore del CL
                "lrv\n" + // risultato della funzione sullo stack
                "lra\n" + "js\n" // salta a $ra
        );
        return "";
    }

    @Override
    public Node getSymType() {
        return symType;
    }
    
    public String getLabel() {
        return label;
    }
    
    public int getOffset() {
        return offset;
    }
}
