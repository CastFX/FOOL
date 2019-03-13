package ast;

public class EmptyTypeNode implements Node {
    
    @Override
    public String toPrint(String indent) {
        return indent + "EmptyTypeNode\n";
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
