package ast;

import lib.FOOLlib;

public class IdNode implements Node {

    private String id;
    private int nestingLevel;
    private STentry entry;

    public IdNode(String i, STentry st, int nl) {
        id = i;
        nestingLevel = nl;
        entry = st;
    }

    public String toPrint(String s) {
        return s + "Id:" + id + " at nestinglevel " + nestingLevel + "\n" + entry.toPrint(s + "  ");
    }


    //ID può essere di tipo funzionale (nome di funzione o var/par di tipo funzionale), ma non deve essere un metodo,
    //(Controllare "isMethod" in STentry).
    //né deve essere il nome di una classe. 
    public Node typeCheck() {
    	//Cannot be a class name
        if (FOOLlib.existsClass(id)) {
            System.out.println("ID exists already as class name");
            System.exit(0);
        }
        
        //Cannot be a method
        if (this.entry.isMethod()) {
        	System.out.println("ID Cannot be a method");
        	System.exit(0);
        }
        // HIGHER ORDER
        //Can be functional
        return entry.getType();
    }

    
    //( Higher Order Extension )
    // Se il tipo non è funzionale, ritorna codice invariato.
    // Se lo è, due cose sono messe nello stack, recuperandole come valori dell'AR dove è dichiarato l'ID
    // utilizzando il meccanismo usuale di risalita della catena statica.
    // Nell'ordine:
    // 1. indirizzo (fp) ad AR dichiarazione funzione. (Recuperato a offset ID)
    // 2. indirizzo funzione (recuperato a offset ID - 1)
    public String codeGeneration() {
        String getAR="";
        for (int i=0; i<nestingLevel-entry.getNestinglevel();i++)
            getAR+="lw\n";
        //Se non è di tipo funzionale
        if (!(entry.getType() instanceof ArrowTypeNode)) {
            return "push " + entry.getOffset() + "\n" +			 
            		"lfp\n" + getAR + //risalgo la catena statica per ottenere l'indirizzo dell'AR in cui � dichiarata la variabile			 
                    "add\n" +
                    "lw\n";
        } else {
      	  //Caso funzionale
      	  return "push " + entry.getOffset() + "\n" + //Faccio push dell'offset ID.
      	      "lfp\n" + getAR +//Risalgo la catena statica per ottenere l'indirizzo dell'AR 
      	                      //in cui è dichiarata la funzione a offset ID.		 
      	      "add\n" +
      	      "lw\n" +
      	      "push " + (entry.getOffset() - 1) + "\n" + //Faccio push dell'offset ID-1.
      	      "lfp\n" + getAR + //Risalgo la catena statica per ottenere l'indirizzio della funzione che si trova a offset ID -1.
      	      "add\n" +
      	      "lw\n";
        }
    }
}