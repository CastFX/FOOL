package ast;

import lib.FOOLlib;

public class EqualNode implements Node {

    private Node left;
    private Node right;

    public EqualNode(Node l, Node r) {
        left = l;
        right = r;
    }

    public String toPrint(String s) {
        return s + "Equal\n" + left.toPrint(s + "  ") + right.toPrint(s + "  ");
    }

    public Node typeCheck() {
        Node l = left.typeCheck();
        Node r = right.typeCheck();
    	//HIGHER ORDER
        //Non è consentito l'uso di espressioni exp-i con tipi funzionali. (Dovrei confrontare coppie di valori)
    	if (l instanceof ArrowTypeNode){ 
    		System.out.println("Invalid use of functional types "+l+" in left side of equal");
    	    System.exit(0);
    	}
    	if (r instanceof ArrowTypeNode){
    		System.out.println("Invalid use of functional types "+r+" in right side of equal");
    	    System.exit(0);
    	}
        if (!(FOOLlib.isSubtype(l, r) || FOOLlib.isSubtype(r, l))) {
            System.out.println("Incompatible types in equal");
            System.exit(0);
        }
        return new BoolTypeNode();
    }

    public String codeGeneration() {
        String l1 = FOOLlib.freshLabel();
        String l2 = FOOLlib.freshLabel();
        return left.codeGeneration() + right.codeGeneration()
            + "beq " + l1 + "\n" 
            + "push 0\n" 
            + "b " + l2 + "\n" + l1 + ": \n" 
            + "push 1\n" 
            + l2 + ": \n";
    }

}