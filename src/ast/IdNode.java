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

    /**
     * ID può essere di tipo funzionale ma non deve essere un metodo.
     * (Controllare "isMethod" in STentry;
     * né deve essere il nome di una classe.
     */
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
        // HIGH ORDER
        //Can be functional
        return entry.getType();
    }

    /**
     * If not functional, unchanged.
     * If functional add 2 things to stack, address AR and function.
     * ( High Order Extension )
     */
    public String codeGeneration() {
    	//HIGH ORDER
    	String getAR="";
        for (int i=0; i<nestingLevel-entry.getNestinglevel();i++)
      	  getAR+="lw\n";
        if (!(entry.getType() instanceof ArrowTypeNode)) {
  		  return "push "+entry.getOffset()+"\n"+			 
  				 "lfp\n"+getAR+ //risalgo la catena statica per ottenere l'indirizzo dell'AR 
  				                //in cui � dichiarata la variabile			 
  				 "add\n"+
  				 "lw\n";
        } else {
      	  //Functional case
      	  return "push "+entry.getOffset()+"\n"+			 
  			 "lfp\n"+getAR+ //Risalgo la catena statica per ottenere l'indirizzo dell'AR 
  			                //in cui � dichiarata la funzione (OFFSET ID)		 
  			 "add\n"+
  			 "lw\n"+
      	  	 "push "+(entry.getOffset()-1)+"\n"+
      	  	 "lfp\n"+getAR+ //Risalgo la catena statica per ottenere l'indirizzio della funzione (OFFSET ID -1)
      	  	 "add\n"+
  			 "lw\n";
        }
    }
}