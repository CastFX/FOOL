package ast;

public class STentry {

    private int nestingLevel;
    private Node type;
    private int offset;
    private boolean isMethod;

    public STentry(int n, int os) {
        nestingLevel = n;
        offset = os;
    }

    public STentry(int n, int os, boolean isMethod) {
        nestingLevel = n;
        offset = os;
        this.isMethod = isMethod;
    }

    public STentry(int n, Node t, int os) {
        nestingLevel = n;
        type = t;
        offset = os;
    }

    public STentry(int n, Node t, int os, boolean isMethod) {
        nestingLevel = n;
        type = t;
        offset = os;
        this.isMethod = isMethod;
    }

    public void addType(Node t) {
        type = t;
    }

    public Node getType() {
        return type;
    }

    public int getOffset() {
        return offset;
    }

    public int getNestinglevel() {
        return nestingLevel;
    }

    public boolean isMethod() {
        return isMethod;
    }

    //DeepCopy per STentry
    public STentry deepCopy() {
        Node typeCopy = null;
        if (type instanceof BoolTypeNode) {
            typeCopy = new BoolTypeNode();
        }
        else if (type instanceof IntTypeNode) {
            typeCopy = new IntTypeNode();
        }
        else if (type instanceof RefTypeNode) {
            typeCopy = new RefTypeNode(((RefTypeNode)type).getId());
        } else if (type instanceof ArrowTypeNode) {
            typeCopy = new ArrowTypeNode(((ArrowTypeNode)type).getParList(), ((ArrowTypeNode)type).getRet());
        }
        return new STentry(nestingLevel, typeCopy, offset, isMethod);
    }
    
    public String toPrint(String s) {
        return s + "STentry: nestlev " + Integer.toString(nestingLevel) + "\n" + 
                s + "STentry: type\n " + type.toPrint(s + "  ")
                + s + "STentry: offset " + offset + "\n"
                + s + "isMethod: " + isMethod +"\n";
    }

}