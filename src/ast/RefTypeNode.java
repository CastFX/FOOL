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

}
