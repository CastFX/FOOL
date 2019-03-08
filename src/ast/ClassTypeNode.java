package ast;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class ClassTypeNode implements Node {

    private ArrayList<Node> allFields = new ArrayList<>();
    private ArrayList<Node> allMethods = new ArrayList<>();

    public ClassTypeNode(ArrayList<Node> fields, ArrayList<Node> methods) {
        allFields = fields;
        allMethods = methods;
    }

    public void insertFieldType(Node type, int position) {
        if (position == allFields.size()) {
            allFields.add(type);
        } else {
            allFields.set(position, type);
        }
    }
    
    public void insertMethodType(Node type, int position) {
        if (position == allMethods.size()) {
            allMethods.add(type);
        } else {
            System.out.println("insertMethodType type: " + type.toPrint("") + " at index: " +position);
            allMethods.set(position, type);
        }
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
            fieldsstr += s + "FieldType\n" + f.toPrint(s + "  ");
        }
        String methodsstr = "";
        for (Node m : allMethods) {
            methodsstr += s + "MethodType\n" + m.toPrint(s + "  ");
        }
        return s + "ClassTypeNode\n" + fieldsstr + methodsstr;
    }
    
    public ClassTypeNode deepCopy() {
        ClassTypeNode ctn = new ClassTypeNode(new ArrayList<>(), new ArrayList<>());
        for (int i = 0; i < allFields.size(); i++) {
            Node typeCopy = deepCopyType(allFields.get(i));
            if (typeCopy != null) {
                ctn.insertFieldType(typeCopy, i);
            }
        }
        for (int i = 0; i < allMethods.size(); i++) {
            Node typeCopy = deepCopyType(allMethods.get(i));
            if (typeCopy != null) {
                ctn.insertMethodType(typeCopy, i);
            }
        }
        return ctn;
    }
    
    public Node deepCopyType(Node type) {
        if (type instanceof IntTypeNode) {
            return new IntTypeNode();
        }
        if (type instanceof BoolTypeNode) {
            return new BoolTypeNode();
        }
        if (type instanceof RefTypeNode) {
            return new RefTypeNode(((RefTypeNode)type).getId());
        }
        return null;
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
