package lib;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import ast.*;

public class FOOLlib {

    private static HashMap<String, String> superType = new HashMap<>();
    private static ArrayList<ArrayList<String>> dispatchTables = new ArrayList<>();         
    private static int labCount = 0;
    private static int funLabCount = 0;
    private static String funCode = "";
    public static final int MEMSIZE = 10000;
    
    public static ArrayList<ArrayList<String>> getDispatchTables() {
        return dispatchTables;
    }
    
    public static HashMap<String, String> getSuperTypeMap() {
        return superType;
    }

    // valuta se il tipo "a" � <= al tipo "b", dove "a" e "b" sono tipi di base:
    // int o bool
    public static boolean isSubtype(Node a, Node b) {

        return  ((a instanceof BoolTypeNode) && (b instanceof BoolTypeNode))
                || ((a instanceof IntTypeNode) && (b instanceof IntTypeNode))
                || ((a instanceof BoolTypeNode) && (b instanceof IntTypeNode))
                || (((a instanceof RefTypeNode) && (b instanceof RefTypeNode))
                        && isRefSubtype(((RefTypeNode) a).getId(), ((RefTypeNode) b).getId()))
                || ((a instanceof EmptyTypeNode) && (b instanceof RefTypeNode))
                || (((a instanceof ArrowTypeNode) && (b instanceof ArrowTypeNode))
                       && isArrowSubtype((ArrowTypeNode) a,(ArrowTypeNode) b))
                ;
    }

    private static boolean isRefSubtype(String subID, String superID) {
        if (subID.equals(superID)) {
            return true;
        }
        if (!existsClass(subID) || !existsClass(superID) || superType.get(subID) == null) {
            return false;
        }
        if (superType.get(subID).equals(superID)) {
            return true;
        } else {
            return isRefSubtype(superType.get(subID), superID);
        }
    }
    
    public static boolean existsClass(String id) {
        return superType.containsKey(id);
    }

    private static boolean isArrowSubtype(ArrowTypeNode a, ArrowTypeNode b) {
        if (!isSubtype(a.getRet().typeCheck(), b.getRet().typeCheck())) {
            System.out.println("return type of arrowtype " + a + " not subtype of ");
            return false;
        }
        List<Node> aPars = a.getParList();
        List<Node> bPars = b.getParList();
        if (aPars.size() != bPars.size()) {
            System.out.println("Paramsize of " + a + " different from paramsize of " + b);
            return false;
        }
        for (int i  = 0; i < aPars.size(); i++) {
            if (!isSubtype(bPars.get(i).typeCheck(), aPars.get(i).typeCheck())) {
                System.out.println("Param from arrowSuperType " + b + " at index " + i + "not subtype of arrowTypeSub " + a);
                return false;
            }
        }
        return true;
    }

    public static String freshLabel() {
        return "label" + (labCount++);
    }

    public static String freshFunLabel() {
        return "function" + (funLabCount++);
    }

    public static void putCode(String c) {
        funCode += "\n" + c; // aggiunge una linea vuota di separazione prima di funzione
    }

    public static String getCode() {
        return funCode;
    }

}
