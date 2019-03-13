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

	public Node typeCheck() {
		ClassTypeNode t = null;
		if (entry.getType() instanceof ClassTypeNode)
			t = (ClassTypeNode) entry.getType();
		else {
			System.out.println("Creation of an object from a non-class " + id);
			System.exit(0);
		}
		ArrayList<Node> parlistTypes = t.getAllFields();
		if (!(parlistTypes.size() == parlist.size())) { //Controllo il numero di parametri
			System.out.println("Wrong number of parameters in the creation of an object from " + id);
			System.exit(0);
		}
		for (int i = 0; i < parlist.size(); i++) //Controllo che ogni parametro sia sottotipo dei tipi aspettati come parametri
			if (!(FOOLlib.isSubtype((parlist.get(i)).typeCheck(), parlistTypes.get(i)))) {
				System.out.println("Wrong type for " + (i + 1) + "-th parameter in the creation of an object from " + id);
				System.exit(0);
			}
		return new RefTypeNode(id);
	}

	public String codeGeneration() {
		String parCode = "";
		String parHPCode = "";
		String incrementHP = "push 1\n" + "lhp\n" + "add\n" + "shp\n";
		for (int i = 0; i < parlist.size(); i++) {
			parCode += parlist.get(i).codeGeneration();
			parHPCode += "lhp\n" + "sw\n" + incrementHP; //Per ogni parametro generato devo scriverlo nell'heap
		}

		return parCode + //genero i parametri
				parHPCode + //dopodiché li pusho sull'heap
				"push " + (FOOLlib.MEMSIZE + entry.getOffset()) + "\n" + //Prendo l'indirizzo del dispatch pointer della classe
				"lw\n" + //carico il dispatch pointer sullo stack
				"lhp\n" + 
				"sw\n" + //Scrivo sull'heap il dispatch pointer a indirizzo Object Pointer
				"lhp\n" + //Lascio sullo stack l'Object Pointer
				incrementHP; //Incremento l'heap pointer
	}
}