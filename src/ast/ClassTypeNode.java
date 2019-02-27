package ast;

import java.util.ArrayList;

public class ClassTypeNode implements Node {

    private ArrayList<Node> allFields = new ArrayList<>();
    private ArrayList<Node> allMethods = new ArrayList<>();

    public ClassTypeNode(ArrayList<Node> fields, ArrayList<Node> methods) {
        allFields = fields;
        allMethods = methods;
    }

    public void insertFieldType(Node type, int position) {
        allFields.add(position, type);
    }
    
    public void insertMethodType(Node type, int position) {
        allMethods.add(position, type);
    }
    
    public ArrayList<Node> getAllFields() {
        return allFields;
    }

    public ArrayList<Node> getAllMethods() {
        return allMethods;
    }

    public String toPrint(String s) {
        String fieldsstr = "";
        for (Node f : allFields) {
            fieldsstr += f.toPrint(s + " ");
        }
        String methodsstr = "";
        for (Node m : allMethods) {
            methodsstr += m.toPrint(s + " ");
        }
        return s + "ClassTypeNode\n" + fieldsstr + methodsstr;
    }

    // non utilizzato
    public Node typeCheck() {
        return null;
    }

    // non utilizzato
    public String codeGeneration() {
        return "";
    }

}
