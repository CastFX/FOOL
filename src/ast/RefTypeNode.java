package ast;

public class RefTypeNode implements Node {

    private String id;
    
    public RefTypeNode(String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }
    
    @Override
    public String toPrint(String indent) {
        return indent + "RefTypeNode:" + id + "\n";
    }

    //Non usato
    @Override
    public Node typeCheck() {
        return null;
    }

    //Non usato
    @Override
    public String codeGeneration() {
        return null;
    }

}
