package ast;

public class EmptyTypeNode implements Node {
    
    @Override
    public String toPrint(String indent) {
        return indent + "EmptyTypeNode\n";
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
