package ast;

import java.util.ArrayList;

import lib.FOOLlib;

public class NewNode implements Node {

    private String id;
    private int nestingLevel;
    private STentry entry;
    private ArrayList<Node> parlist = new ArrayList<Node>();

    public NewNode(String i, STentry st, ArrayList<Node> p, int nl) {
        id = i;
        nestingLevel = nl;
        entry = st;
        parlist = p;
    }

    public String toPrint(String s) {
        String parlstr = "";
        for (Node par : parlist) {
            parlstr += par.toPrint(s + "  ");
        }
        return s + "NewNode:" + id + " at nestinglevel " + nestingLevel + "\n" + entry.toPrint(s + "  ") + parlstr;
    }


    //TODO
    public Node typeCheck() {
        ClassTypeNode t = null;
        if (entry.getType() instanceof ClassTypeNode)
            t = (ClassTypeNode) entry.getType();
        else {
            System.out.println("Creation of an object from a non-class " + id);
            System.exit(0);
        }
        ArrayList<Node> p = t.getAllFields();
        if (!(p.size() == parlist.size())) {
            System.out.println("Wrong number of parameters in the creation of an object from " + id);
            System.exit(0);
        }
        for (int i = 0; i < parlist.size(); i++)
            if (!(FOOLlib.isSubtype((parlist.get(i)).typeCheck(), p.get(i)))) {
                System.out.println("Wrong type for " + (i + 1) + "-th parameter in the creation of an object from " + id);
                System.exit(0);
            }
        return new RefTypeNode(id);
    }


    //TODO
    public String codeGeneration() {
        String parCode = "";
        String parHPCode = "";
        String incrementHP = "push 1\n" + "lhp\n" + "add\n" + "shp\n";
        for (int i = 0; i < parlist.size(); i++) {
            parCode += parlist.get(i).codeGeneration();
            parHPCode += "lhp\n" + "sw\n" + incrementHP;
        }
        //System.out.println("new Node parlist: " + parlist);
//        System.out.println("new Node code: \n" + parCode +
//                parHPCode +
//                "push " + (FOOLlib.MEMSIZE + entry.getOffset()) + "\n" +
//                "lw\n" +
//                "lhp\n" + 
//                "sw\n" + 
//                "lhp\n" +
//                "lw\n" +
//                incrementHP);
        return parCode +
                parHPCode +
                "push " + (FOOLlib.MEMSIZE + entry.getOffset()) + "\n" +
                "lw\n" +
                "lhp\n" + 
                "sw\n" +
                "lhp\n" +
                //"lw\n" +
                incrementHP;
    }
}