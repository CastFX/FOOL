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

    /**
     * Controllo se ID è un metodo ("isMethod" in STentry)
     * Se non lo è, ritorno codice Higher Order
     * Se lo è, ritorno codice Object Oriented
     */
    public String codeGeneration() {
    	if (this.entry.isMethod()) {
    		//Ritorno codice Object Oriented
	        String parCode = "";
	        for (int i = parlist.size() - 1; i >= 0; i--)
	            parCode += parlist.get(i).codeGeneration();
	        String getAR = "";
	        for (int i = 0; i < nestingLevel - entry.getNestinglevel() + (entry.isMethod() ? 1 : 0) ; i++)
	            getAR += "lw\n";
	        return "/*CallNode: " + id + "()*/\n" +
	                "lfp\n" + parCode +      // allocazione valori parametri
	                "lfp\n" + getAR +       // risalgo la catena statica per ottenere l'indirizzo dell'AR in cui 
	                                       //è dichiarata la funzione (Access Link)
	                "push " + entry.getOffset() + "\n" +
	                "lfp\n" + getAR +       // risalgo la catena statica per ottenere l'indirizzo dell'AR in cui è dichiarata la
	                                        // funzione (Access Link)
	                "add\n" + "lw\n" +      // carica sullo stack l'indirizzo della funzione
	                "js\n";                 // effettua il salto
    	}
    	//Ritorno codice Higher Order
    	String parCode="";
  	  	for (int i=parlist.size()-1; i>=0; i--) 
  		  parCode+=parlist.get(i).codeGeneration();
        String getAR="";
        for (int i=0; i<nestingLevel-entry.getNestinglevel();i++)
      	  getAR+="lw\n";      
  	  	return "lfp\n"+ //Contro Link
  			 parCode+ //allocazione valori parametri			          		 
  			 "push "+(entry.getOffset())+"\n"+			 
  			 "lfp\n"+getAR+ //Risalgo la catena statica per ottenere indirizzo dichiarazione funzione (OFFSET ID)
  			 "add\n"+
  			 "lw\n"+ 
  			 "push "+(entry.getOffset()-1)+"\n"+
  			 "lfp\n"+getAR+ //Risalgo la catena statica per ottenere indirizzo della funzione (OFFSET ID-1)
  			 "add\n"+
  			 "lw\n"+
  	         "js\n"; //effettua il salto
    	
    }
}