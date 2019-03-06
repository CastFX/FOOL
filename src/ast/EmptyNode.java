package ast;

public class EmptyNode implements Node {

    @Override
    public String toPrint(String indent) {
        return indent + "EmptyNode\n";
    }

    @Override
    public Node typeCheck() {
        return new EmptyTypeNode();
    }

    @Override
    public String codeGeneration() {
        return "push -1\n";
    }

}
