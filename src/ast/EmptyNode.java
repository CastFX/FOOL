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

    //Null equivale a -1 ed è sicuramente diverso da tutti gli altri ObjectPointer ( >= 0) 
    @Override
    public String codeGeneration() {
        return "push -1\n";     
    }

}
