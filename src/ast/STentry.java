package ast;

public class STentry {

    private int nl;
    private Node type;
    private int offset;
    private boolean isMethod;

    public STentry(int n, int os) {
        nl = n;
        offset = os;
    }

    public STentry(int n, int os, boolean isMethod) {
        nl = n;
        offset = os;
        this.isMethod = isMethod;
    }

    public STentry(int n, Node t, int os) {
        nl = n;
        type = t;
        offset = os;
    }

    public STentry(int n, Node t, int os, boolean isMethod) {
        nl = n;
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
        return nl;
    }

    public boolean isMethod() {
        return isMethod;
    }

    public String toPrint(String s) {
        return s + "STentry: nestlev " + Integer.toString(nl) + "\n" + s + "STentry: type\n " + type.toPrint(s + "  ")
                + s + "STentry: offset " + offset + "\n";
    }

}