package ast;

import java.util.ArrayList;

import lib.FOOLlib;

public class ClassCallNode implements Node {

    private String id;
    private int nestingLevel;
    private STentry entry;
    private STentry methodEntry;
    private ArrayList<Node> parlist = new ArrayList<Node>();

    public ClassCallNode(String i, STentry st, STentry mst, ArrayList<Node> p, int nl) {
        id = i;
        nestingLevel = nl;
        entry = st;
        methodEntry = mst;
        parlist = p;
    }

    public String toPrint(String s) {
        String parlstr = "";
        for (Node par : parlist) {
            System.out.println(par.getClass());
            parlstr += par.toPrint(s + "  ");
        }
        return s + "Method Call:" + id + " at nestinglevel " + nestingLevel + "\n" 
            + entry.toPrint(s + "  ") 
            + (methodEntry == null ? methodEntry.toPrint(s + "  ") : "") 
            + parlstr;
    }

    public Node typeCheck() {
        ArrowTypeNode t = null;
        if (methodEntry != null && methodEntry.getType() instanceof ArrowTypeNode)
            t = (ArrowTypeNode) methodEntry.getType();
        else {
            System.out.println("Invocation of a non-function " + id + ",instead: " + methodEntry.getType());
            System.exit(0);
        }
        ArrayList<Node> p = t.getParList();
        if (!(p.size() == parlist.size())) {
            System.out.println("Wrong number of parameters in the invocation of " + id);
            System.exit(0);
        }
        for (int i = 0; i < parlist.size(); i++)
            if (!(FOOLlib.isSubtype((parlist.get(i)).typeCheck(), p.get(i)))) {
                System.out.println("Wrong type for " + (i + 1) + "-th parameter in the invocation of " + id);
                System.exit(0);
            }
        return t.getRet();
    }

    public String codeGeneration() {
        String parCode = "";
        for (int i = parlist.size() - 1; i >= 0; i--)
            parCode += parlist.get(i).codeGeneration();
        String getObjectAR = "";
        for (int i = 0; i < nestingLevel - entry.getNestinglevel(); i++)
            getObjectAR += "lw\n";
        
        //Per ottenere il puntatore all'oggetto
        String getObjectPointer = "lfp\n" + //carico il Frame Pointer corrente
        		getObjectAR + // risalgo la catena statica per ottenere l'indirizzo dell'AR in cui è dichiarata la variabile
        		"push " + entry.getOffset() + "\n" + //a cui viene sommato l'offset dell'IdNode dell'oggetto
        		"add\n" + //la somma è l'indirizzo nello stack dell'Object Pointer
        		"lw\n"; //e poi prendo l'indirizzo del puntatore all'oggetto, ossia l'indirizzo nell'heap dove risiede l'oggetto

        return "lfp\n" + //Come prima cosa pusho il ControlLink
                parCode + //Carico sullo stack tutti i parametri
                getObjectPointer + //Carico sullo stack l'ObjectPointer che mi servirà dopo
                getObjectPointer + //Carico ancora l'Object Pointer
                "lw\n" + //All'indirizzo dell'ObjectPointer risiede il Dispatch Pointer della classe 
                "push " + (methodEntry.getOffset()) + "\n" + //A cui viene sommato l'offset per ottenere il metodo chiamato
                "add\n" +
                "lw\n" + //Si ottiene all'indirizzo della funzione nel codice
                "js\n"
                ;
    }
}