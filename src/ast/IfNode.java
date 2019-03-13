package ast;

import lib.FOOLlib;

public class IfNode implements Node {

    private Node cond;
    private Node th;
    private Node el;

    public IfNode(Node c, Node t, Node e) {
        cond = c;
        th = t;
        el = e;
    }

    public String toPrint(String s) {
        return s + "If\n" + cond.toPrint(s + "  ") + th.toPrint(s + "  ") + el.toPrint(s + "  ");
    }

    public Node typeCheck() {
        if (!(FOOLlib.isSubtype(cond.typeCheck(), new BoolTypeNode()))) {
            System.out.println("non boolean condition in if");
            System.exit(0);
        }
        Node t = th.typeCheck();
        Node e = el.typeCheck();
        
        //Controllo che siano uno il subtype dell'altro, e ritorno il supertipo
        if (FOOLlib.isSubtype(t, e)) {
            return e;
        }
        if (FOOLlib.isSubtype(e, t)) {
            return t;
        }
        
        
        //class A
        //class B extends A
        //class C extends A
        //class D extends B
        //class E extends C
        //A x = if (cond) then (D) else (E)
        //int i = if (bool) then (bool) else (int)
        //Trovo il primo common ancestor per avere un tipo minimo valido per entrambi i branch
        Node lca = FOOLlib.lowestCommonAncestor(t, e);
        if (lca == null) { //Se non c'è non è possibile ritornare un tipo valido per entrambi i branch
            System.out.println("Incompatible types in then-else branches");
            System.exit(0);
        }
        return lca;
    }

    public String codeGeneration() {
        String l1 = FOOLlib.freshLabel();
        String l2 = FOOLlib.freshLabel();
        return cond.codeGeneration() +
                "push 1\n" + "beq " + l1 + "\n" + el.codeGeneration() + "b " + l2 + "\n" + l1
                + ": \n" + th.codeGeneration() + l2 + ": \n";
    }

}