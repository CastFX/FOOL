package ast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

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
            + (superEntry != null ? (" extends:" + superId + "\n" + superEntry.getType().toPrint(indent + "  ext:")) :  "\n")
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
        ArrayList<String> dispatchTable = new ArrayList<>();
        if (superEntry != null) {
            dispatchTable.addAll(FOOLlib.getDispatchTables().get(-superEntry.getOffset() - 2));
        }
        FOOLlib.getDispatchTables().add(dispatchTable);
//        ArrayList<Node> sortedMethods = new ArrayList<>(methods);
//        Collections.sort(sortedMethods, new Comparator<Node>() {
//           public int compare(Node n1, Node n2) {
//               Integer oN1 = ((MethodNode)n1).getOffset();
//               Integer oN2 = ((MethodNode)n2).getOffset();
//               return oN1.compareTo(oN2);
//           }
//        });
        
        for (Node m : methods) {
            m.codeGeneration();
            int offset = ((MethodNode)m).getOffset();
            String label = ((MethodNode)m).getLabel();
            System.out.println("adding method: " + label + ",at offset:" +offset +" for class " + id + ", dispatchTable.Size(): " + dispatchTable.size());
            if (offset >= dispatchTable.size()) {
                dispatchTable.add(offset, label);
            } else {
                dispatchTable.set(offset, label);
            }
        }
        System.out.println("class: " + id + ", dispatchTable: " + dispatchTable);
        
        //DispatchTable Create ok
        String incrementHP = "push 1\n" + "lhp\n" + "add\n" + "shp\n";
        String memLabelInHP = "";
        for (String l : dispatchTable) {
            memLabelInHP += "push " +  l + "\n" 
                    + "lhp\n"
                    + "sw\n"
                    + incrementHP;
        }
        //System.out.println("memLabel\n" + memLabelInHP);
        return  "\n/*ClassNode: " + id + "*/\n" +
                "lhp\n" +
                memLabelInHP
                ;
    }

    @Override
    public Node getSymType() {
        return symType;
    }
}
