package ast;

import lib.FOOLlib;

public class LesserEqualNode implements Node {

	private Node left;
	private Node right;

	public LesserEqualNode(Node l, Node r) {
		left = l;
		right = r;
	}

	public String toPrint(String s) {
		return s + "LesserEqual\n" + left.toPrint(s + "  ") + right.toPrint(s + "  ");
	}

	/**
	 * @author Maicol
	 * 
	 *         TODO Don't consent the use with functional types ( High Order
	 *         Extension )
	 */
	public Node typeCheck() {
		if (left instanceof ArrowTypeNode) {
			System.out.println("Invalid use of functional types " + left + " in left side of lesser equal");
			System.exit(0);
		}
		if (right instanceof ArrowTypeNode) {
			System.out.println("Invalid use of functional types " + right + " in right side of lesser equal");
			System.exit(0);
		}
		Node l = left.typeCheck();
		Node r = right.typeCheck();
		if (!(FOOLlib.isSubtype(l, r) || FOOLlib.isSubtype(r, l))) {
			System.out.println("Incompatible types in lesser equal");
			System.exit(0);
		}
		return new BoolTypeNode();
	}

	public String codeGeneration() {
		String l1 = FOOLlib.freshLabel();
		String l2 = FOOLlib.freshLabel();
		return left.codeGeneration() + right.codeGeneration() + "bleq " + l1 + "\n" + "push 0\n" + "b " + l2 + "\n" + l1
				+ ": \n" + "push 1\n" + l2 + ": \n";
	}

}