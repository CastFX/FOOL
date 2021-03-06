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
            + (superEntry != null ? (" extends:" + superId + "\n" + superEntry.getType().toPrint(indent + "  ext:")) :  "\n")
            + fieldlstr
            + methlstr;
    }

    @Override
    public Node typeCheck() {
    	//Typecheck per ogni figlio metodo
        for (Node m : methods) {
            m.typeCheck();
        }
        //Controllo il corretto tipo di symType e eventualmente il tipo della superclasse
        if (!(symType instanceof ClassTypeNode) ||
            superEntry != null && !(superEntry.getType() instanceof ClassTypeNode)) {
            System.out.println("either symType or superEntry of ClassNode not of ClassTypeNode");
            System.exit(0);
        }
        
        //Dopo aver fatto il typecheck di tutti i figli singolarmente, bisogna controllare che quelli che fanno override
        //siano sottotipi di quelli specificati dalla superclasse
        if (superEntry != null) {
            final ClassTypeNode ctnSuper =  (ClassTypeNode) superEntry.getType();
            fields.stream()
            .map(n -> (FieldNode) n) //per ogni FieldNode
            .forEach(f -> {
                int fieldPosition = -f.getOffset() - 1; 
                if (fieldPosition < ctnSuper.getAllFields().size() && //Se l'offset è uguale ad uno di quelli della superclasse 
                        !FOOLlib.isSubtype(f.getSymType(), ctnSuper.getAllFields().get(fieldPosition))) { //Typecheck per override corretto
                    System.out.println("Field type " + fields.indexOf(f) + " of class " + id 
                            + " not subtype of overridden method from superclass");
                    System.exit(0);
                }
            });
        
            //Stesso per i metodi
            methods.stream()
            	.map(n -> (MethodNode) n)
            	.forEach(m -> {
            		int methodPosition = m.getOffset();
            		if (methodPosition < ctnSuper.getAllMethods().size() &&
                        !FOOLlib.isSubtype(m.getSymType(), ctnSuper.getAllMethods().get(methodPosition))) {
            			System.out.println("Method of type " + methods.indexOf(m) + " of class " + id 
                            + " not subtype of overridden method from superclass");
            			System.exit(0);
            		}});
        }
        return symType;
    }

    @Override
    public String codeGeneration() {
        ArrayList<String> dispatchTable = new ArrayList<>();
        
        if (superEntry != null) { //Se la classe estende un'altra, aggiungo tutte le altre
            dispatchTable.addAll(FOOLlib.getDispatchTables().get(-superEntry.getOffset() - 2)); //-2 perchè le classi partono da offset 0 a nesting level 0
        }
        //Aggiungo la dispatchTable alla lista di tutte le dispatchTable di tutte le classi
        FOOLlib.getDispatchTables().add(dispatchTable);
        int dispatchTableSize = dispatchTable.size();
        //Scorro i metodi figli
        for (Node m : methods) {
            m.codeGeneration();
            int offset = ((MethodNode)m).getOffset();
            String label = ((MethodNode)m).getLabel();
            
            //Controllo se è un metodo che fa override guardando se l'offset settato è tra quelli ereditati
            if (offset >= dispatchTableSize) { //Se offset è maggiore non sta facendo override quindi lo aggiungo all'offset specificato
            	dispatchTable.add(offset, label);
            } else { //Se offset è minore devo anche sostituire la vecchia label di metodo su cui viene fatto l'override
                dispatchTable.set(offset, label);
            }
        }
        
        //Codice per incrementare heap pointer
        String incrementHP = "push 1\n" + "lhp\n" + "add\n" + "shp\n";
        
        //Codice per salvare tutti gli indirizzi di tutti i metodi della classe nell'heap.
        //Il primo indirizzo di metodo verrà scritto ad indirizzo che diventerà il DispatchPointer della classe
        String memLabelInHP = "";
        for (String label : dispatchTable) {
            memLabelInHP += "push " +  label + "\n" //Carico l'indirizzo del metodo sullo stack
                    + "lhp\n" //Setto l'indirizzo ad heap pointer attuale
                    + "sw\n" //Scrivo nello heap l'indirizzo del metodo
                    + incrementHP; //Incremento heap pointer
        }
        return  "lhp\n" + memLabelInHP; //Prima carico il Dispatch Pointer della classe nell'heap
        								//Poi alloco gli indirizzi dei metodi nello heap
    }

    @Override
    public Node getSymType() {
        return symType;
    }
}
