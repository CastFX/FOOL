package ast;

import java.util.ArrayList;

import lib.FOOLlib;

public class ClassNode implements Node, DecNode {

    private String id;
    private String superId;
    private ArrayList<Node> fields = new ArrayList<>();
    private ArrayList<Node> methods = new ArrayList<>();
    private Node symType;
    private STentry superEntry;
    
    public ClassNode(String id, Node symType, String superId, STentry superEntry) {
        this.id = id;
        this.symType = symType;
        this.superId = superId;
        this.superEntry = superEntry;
    }
    
    public void addField(Node field) {
        fields.add(field);
    }

    public void addMethod(Node method) {
        methods.add(method);
    }

    @Override
    public String toPrint(String indent) {
        String fieldlstr = "";
        for (Node par : fields) {
            fieldlstr += par.toPrint(indent + "  ");
        }
        String methlstr = "";
        for (Node mdec : methods) {
            methlstr += mdec.toPrint(indent + "  ");
        }
        return indent + "Class:" + id
            + (" extends:" + superId + "\n" + (superEntry != null ? superEntry.getType().toPrint(indent + "  ext:") :  "\n"))
            //+ symType.toPrint(indent + "  ")
            + fieldlstr
            + methlstr;
    }

    @Override
    public Node typeCheck() {
        for (Node m : methods) {
            m.typeCheck();
        }
        if (!(symType instanceof ClassTypeNode) ||
            !(superEntry.getType() instanceof ClassTypeNode)) {
            System.out.println("either symType or superEntry of ClassNode not of ClassTypeNode");
            System.exit(0);
        } else {
            ClassTypeNode ctnSuper = (ClassTypeNode) superEntry.getType();
            ClassTypeNode ctnSub = (ClassTypeNode) symType;
            for (int i = 0; i < ctnSuper.getAllFields().size(); i++) {
                if (!FOOLlib.isSubtype(ctnSuper.getAllFields().get(i).typeCheck()
                        , ctnSub.getAllFields().get(i).typeCheck())) {
                    System.out.println("field type" + i + " of superclass not subtype of current");
                    System.exit(0);
                }
            }
            
            for (int i = 0; i < ctnSuper.getAllMethods().size(); i++) {
                if (!FOOLlib.isSubtype(ctnSuper.getAllMethods().get(i).typeCheck()
                        , ctnSub.getAllMethods().get(i).typeCheck())) {
                    System.out.println("method type" + i + " of superclass not subtype of current");
                    System.exit(0);
                }
            }
        }
        return symType;
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
