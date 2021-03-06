package ast;

import java.util.ArrayList;

import lib.FOOLlib;

public class ProgLetInNode implements Node {

    private ArrayList<Node> classlist;
    private ArrayList<Node> declist;
    private Node exp;

    public ProgLetInNode(ArrayList<Node> c, ArrayList<Node> d, Node e) {
        classlist = c;
        declist = d;
        exp = e;
    }

    
    public String toPrint(String s) {
        String clslstr = "";
        for (Node cls : classlist) {
            clslstr += cls.toPrint(s + "  ");
        }
        String declstr = "";
        for (Node dec : declist) {
            declstr += dec.toPrint(s + "  ");
        }
        
        return s + "ProgLetIn\n" + clslstr + declstr + exp.toPrint(s + "  ");
    }

    public Node typeCheck() {
    	
    	//Aggiunta typecheck anche delle classi
        for (Node cl : classlist) {
            cl.typeCheck();
        }
        for (Node dec : declist) {
            dec.typeCheck();
        }
        return exp.typeCheck();
    }

    public String codeGeneration() {
        String declCode = "";
        String classCode = "";
        for (Node cl : classlist) { //Genero il codice anche delle classi
            classCode += cl.codeGeneration();
        }
        for (Node dec : declist)
            declCode += dec.codeGeneration();
        return "push 0\n" +
                classCode + "\n" +
                declCode + "\n" +
                exp.codeGeneration() + 
                "halt\n" + 
                FOOLlib.getCode();
    }

}