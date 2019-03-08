package ast;

public class FieldNode implements Node, DecNode {

    private String id;
    private Node type;
    private int offset;

    public FieldNode(String i, Node t, int o) {
        id = i;
        type = t;
        offset = o;
    }

    public String toPrint(String s) {
        return s + "Field:" + id + "\n" + type.toPrint(s + "  ");
    }

    // non utilizzato
    public Node typeCheck() {
        return null;
    }

    public String codeGeneration() {
        return "";
    }

    @Override
    public Node getSymType() {
        // TODO Auto-generated method stub
        return null;
    }
    
    public int getOffset() {
        return offset;
    }

}
