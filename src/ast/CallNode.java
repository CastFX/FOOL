package ast;

import java.util.ArrayList;

import lib.FOOLlib;

public class CallNode implements Node {

    private String id;
    private int nestingLevel;
    private STentry entry;
    private ArrayList<Node> parlist = new ArrayList<Node>();

    public CallNode(String i, STentry st, ArrayList<Node> p, int nl) {
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
        ;
        return s + "Call:" + id + " at nestinglevel " + nestingLevel + "\n" + entry.toPrint(s + "  ") + parlstr;
    }

    //Il check è invariato, il tipo dell'ID deve essere di tipo funzionale. (Nome di funzione o var/par di tipo funzionale)
    public Node typeCheck() {
        ArrowTypeNode t = null;
        if (entry.getType() instanceof ArrowTypeNode)
            t = (ArrowTypeNode) entry.getType();
        else {
            System.out.println("Invocation of a non-function " + id);
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

    //Controllo se ID è un metodo ("isMethod" in STentry)
    //Se lo è, ritorno codice Object Oriented
    //Se non lo è, ritorno codice Higher Order
    public String codeGeneration() {
    	//Controllo se ID è un metodo
    	if (this.entry.isMethod()) {
    	    //Ritorno codice Object Oriented
    	    String parCode = "";
    	    for (int i = parlist.size() - 1; i >= 0; i--)
    	        parCode += parlist.get(i).codeGeneration();
    	    String getAR = "";
	    for (int i = 0; i < nestingLevel - entry.getNestinglevel() + (entry.isMethod() ? 1 : 0) ; i++)
	        getAR += "lw\n";
	    return "lfp\n" + 			//Control Link
	        parCode +               // allocazione valori parametri
	        "lfp\n" + getAR +       // risalgo la catena statica per ottenere l'indirizzo dell'AR in cui 
	                                //è dichiarata la funzione (Access Link)
	        "push " + entry.getOffset() + "\n" +
	        "lfp\n" + getAR +       // risalgo la catena statica per ottenere l'indirizzo dell'AR in cui è dichiarata la
	                                // funzione (Access Link)
	        "add\n" + "lw\n" +      // carica sullo stack l'indirizzo della funzione
	        "js\n";                 // effettua il salto
    	}
    	//Ritorno codice Higher Order
    	//Due cose sono recuperate come valori dall'AR dove è dichiarato l'ID con meccanismo usuale di risalita catena statica.
    	//1. Indirizzo (fp) ad AR dichiarazione funzione (recuperato a offset ID), usato per settare nuovo Access Link (AL).
    	//2. Indirizzo della funzione (Recuperato a offset ID - 1), usato per saltare a codice funzione.
    	String parCode="";
  	  	for (int i = parlist.size() - 1; i >= 0; i--) 
  		  parCode += parlist.get(i).codeGeneration();
        String getAR="";
        for (int i = 0; i < nestingLevel - entry.getNestinglevel(); i++)
      	  getAR += "lw\n";      
        return "lfp\n" + //Control Link
            parCode + //allocazione valori parametri			          		 
            "push " + (entry.getOffset()) + "\n" +	 // Push dell'offset ID
            "lfp\n" + getAR + //Risalgo la catena statica per ottenere indirizzo dichiarazione funzione a offset ID.
            "add\n" +
            "lw\n" + 
            "push " +(entry.getOffset()-1)+"\n"+ //Push dell'offset ID - 1
            "lfp\n" + getAR +  //Risalgo la catena statica per ottenere indirizzo della funzione a offset ID-1.
            "add\n" +
            "lw\n" +
            "js\n"; //effettua il salto
    }
}