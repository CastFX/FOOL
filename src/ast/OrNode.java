package ast;

import lib.FOOLlib;

public class OrNode implements Node {

	private Node left;
	private Node right;

	public OrNode(Node l, Node r) {
		left = l;
		right = r;
	}

	public String toPrint(String s) {
		return s + "OR\n" + left.toPrint(s + "  ") + right.toPrint(s + "  ");
	}

	public Node typeCheck() {
		Node l = left.typeCheck();
		Node r = right.typeCheck();
		if (!(l instanceof BoolTypeNode) || !(r instanceof BoolTypeNode)) {
			System.out.println("Incompatible types in OR");
			System.exit(0);
		}
		return new BoolTypeNode();
	}

	public String codeGeneration() {
		String l1 = FOOLlib.freshLabel();
		String l2 = FOOLlib.freshLabel();
		return left.codeGeneration() + "push 1\n" + "beq " + l1 + "\n" + right.codeGeneration() + "push 1\n" + "beq "
				+ l1 + "\n" + "push 0\n" + "b " + l2 + "\n" + l1 + ": \n" + "push 1\n" + l2 + ": \n";
	}

}