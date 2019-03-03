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
        String getAR = "";
        for (int i = 0; i < nestingLevel - entry.getNestinglevel(); i++)
            getAR += "lw\n";
        return "lfp\n" + // Contro Link
                parCode + // allocazione valori parametri
                "lfp\n" + getAR + // risalgo la catena statica per ottenere
                                  // l'indirizzo dell'AR
                                  // in cui � dichiarata la funzione (Access
                                  // Link)
        "push " + entry.getOffset() + "\n" + "lfp\n" + getAR + // risalgo la
                                                               // catena statica
                                                               // per ottenere
                                                               // l'indirizzo
                                                               // dell'AR
                                                               // in cui �
                                                               // dichiarata la
                                                               // funzione
                                                               // (Access Link)
        "add\n" + "lw\n" + // carica sullo stack l'indirizzo della funzione
                "js\n"; // effettua il salto
    }
}