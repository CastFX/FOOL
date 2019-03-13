package lib;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import ast.*;

public class FOOLlib {

    private static HashMap<String, String> superTypeMap = new HashMap<>();
    private static ArrayList<ArrayList<String>> dispatchTables = new ArrayList<>();         
    private static int labCount = 0;
    private static int funLabCount = 0;
    private static String funCode = "";
    public static final int MEMSIZE = 1000;
    
    public static ArrayList<ArrayList<String>> getDispatchTables() {
        return dispatchTables;
    }
    
    public static HashMap<String, String> getSuperTypeMap() {
        return superTypeMap;
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
                || ((a instanceof EmptyTypeNode) && (b instanceof EmptyTypeNode))
                || (((a instanceof ArrowTypeNode) && (b instanceof ArrowTypeNode))
                       && isArrowSubtype((ArrowTypeNode) a,(ArrowTypeNode) b))
                ;
    }

    private static boolean isRefSubtype(String subID, String superID) {
        if (subID == null || superID == null) {
            return false;
        }
        if (subID.equals(superID)) {
            return true;
        }
        if (!existsClass(subID) || !existsClass(superID) || superTypeMap.get(subID) == null) {
            return false;
        }
        if (superTypeMap.get(subID).equals(superID)) {
            return true;
        } else {
            return isRefSubtype(superTypeMap.get(subID), superID);
        }
    }
    
    public static boolean existsClass(String id) {
        return superTypeMap.containsKey(id);
    }
    
    public static Node lowestCommonAncestor(Node thenExp, Node elseExp) {
        //Lo dovrebbe già fare la isSubtype();
        if (!(thenExp instanceof EmptyTypeNode) && elseExp instanceof EmptyTypeNode) {
            return thenExp;
        }
        if (thenExp instanceof EmptyTypeNode && !(elseExp instanceof EmptyTypeNode)) {
            return elseExp;
        }
        
        if ((thenExp instanceof BoolTypeNode || thenExp instanceof IntTypeNode) &&
                elseExp instanceof BoolTypeNode || elseExp instanceof IntTypeNode) {
            if (thenExp instanceof IntTypeNode || elseExp instanceof IntTypeNode) {
                return new IntTypeNode();
            } else {
                return new BoolTypeNode();
            }
        }
        
        if (thenExp instanceof RefTypeNode && elseExp instanceof RefTypeNode) {
            RefTypeNode thenRefNode = (RefTypeNode) thenExp;
            String elseStringClass = ((RefTypeNode) elseExp).getId();
            for (String superClass = superTypeMap.get(thenRefNode.getId()); 
                    superClass != null; 
                    superClass = superTypeMap.get(superClass)) {
                if (isRefSubtype(elseStringClass, superClass)) {
                    return new RefTypeNode(superClass);
                }
            }
        }
        
        if ((thenExp instanceof ArrowTypeNode) && (elseExp instanceof ArrowTypeNode)) {
			// Both are ArrowTypeNode
			// Check if same number of parameters
			ArrowTypeNode arrowA = (ArrowTypeNode) thenExp;
			ArrowTypeNode arrowB = (ArrowTypeNode) elseExp;
			if (arrowA.getParList().size() == arrowB.getParList().size()) {
				Node covariance = lowestCommonAncestor(arrowA.getRet(), arrowB.getRet());
				ArrayList<Node> paramList = new ArrayList<>();
				if ( covariance != null) {
					for (int i = 0; i < arrowA.getParList().size(); i++) {
						if (isSubtype(arrowA.getParList().get(i), arrowB.getParList().get(i))){
							paramList.add(arrowA.getParList().get(i));
						} else {
							if (isSubtype(arrowB.getParList().get(i), arrowA.getParList().get(i))) {
								paramList.add(arrowB.getParList().get(i));
							} else {
								return null;
							}
						}
					}
					return new ArrowTypeNode(paramList, covariance);
				}
			}
        }
        return null;
    }

    private static boolean isArrowSubtype(ArrowTypeNode a, ArrowTypeNode b) {
        if (!isSubtype(a.getRet(), b.getRet())) {
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
            if (!isSubtype(bPars.get(i), aPars.get(i))) {
                System.out.println("Param from arrowSuperType " + b + " at index " + i + " not subtype of arrowTypeSub " + a);
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
