package ast;

import java.util.ArrayList;

public class ClassNode implements Node, DecNode {

    private String id;
    private ArrayList<Node> fields = new ArrayList<>();
    private ArrayList<Node> methods = new ArrayList<>();
    private Node symType;

    public ClassNode(String id) {
        this.id = id;
    }
    
    public void addField(Node field) {
        fields.add(field);
    }

    public void addMethod(Node method) {
        methods.add(method);
    }

    @Override
    public String toPrint(String indent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Node typeCheck() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String codeGeneration() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Node getSymType() {
        return symType;
    }
}
