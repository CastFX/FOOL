package lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import ast.ClassTypeNode;
import ast.Node;
import ast.RefTypeNode;
import ast.STentry;

/*
 * Class helper per gestire stampe di errore durante il parsing
 * E ridurre il codice presente in FOOL.g4
 */
public final class FOOLParsingLib {

    public static void ensureMethodNotOverridden(HashSet<String> names, String id, int line) {
        ensureNotOverriddenInSameClass(names, id, line, "Method");
    }
    
    public static void ensureFieldNotOverridden(HashSet<String> names, String id, int line) {
        ensureNotOverriddenInSameClass(names, id, line, "Field");
    }
    
    private static void ensureNotOverriddenInSameClass(HashSet<String> names, String id, int line, String type) {
        if (names.contains(id)) {
            fail("Cannot override " + type + " " + id + " at line " + line);
        }
        names.add(id);
    }
    
    public static void addClassToSymTable(HashMap<String, STentry> map, String id, STentry entry, int line) {
        if (map.put(id, entry) != null) { //niente override tra classi
            fail("Class id: " + id + " at line " + line + " already declared");
        } 
    }
    
    public static void ensureExtendedClassExists(HashMap<String, STentry> map, String id, int line) {
        if (!map.containsKey(id)) {
            fail("Super class id: " + id + " at line: " + line + " does not exist");
        }
    }
    
    public static void ensureClassTableContainsMethod(HashMap<String, STentry> map, String id, int line) {
        if (!map.containsKey(id)) {
            fail("Method Id " + id + " at line " + line + " not declared");
        }
    }
    
    public static void ensureFieldSTEntryNotMethod(STentry entry, String id, int line) {
        if (entry.isMethod()) {
            fail("STentry for Field id: " + id + " at line " + line + " already declared as method");
        }
    }
    
    public static void ensureMethodSTentryIsMethod(STentry entry, String id, int line) {
        if (!entry.isMethod()) {
            fail("STentry for Method id: " + id + " at line " + line + " already declared as non-method");
        }
    }
    
    public static void ensureExtendedSTentryType(STentry entry, String id, int line) {
        ensureTypesEqual(entry.getType(), ClassTypeNode.class, id + " extended at line " + line + " is not a class");
    }
    
    public static void ensureIDIsRefTypeNode(STentry entry, String id, int line) {
        ensureTypesEqual(entry.getType(), RefTypeNode.class, "Id: " + id + " not instance of RefTypeNode at line " + line);
    }
    
    private static void ensureTypesEqual(Object obj, Class<?> type, String message) {
        if (!type.isInstance(obj)) {
            fail(message);
        }
    }
    
    public static void addParamSTentryToSymbolTable(HashMap<String, STentry> map, String id,
            int nestingLevel, Node type, int offset, int line) {
        addSTentryToSymbolTable(map, id, nestingLevel, type, offset, line, "Parameter");
    }
    
    public static void addVarSTentryToSymbolTable(HashMap<String, STentry> map, String id,
            int nestingLevel, Node type, int offset, int line) {
        addSTentryToSymbolTable(map, id, nestingLevel, type, offset, line, "Variable");
    }

    public static void addFunSTentryToSymbolTable(HashMap<String, STentry> map, String id,
            int nestingLevel, Node type, int offset, int line) {
        addSTentryToSymbolTable(map, id, nestingLevel, type, offset, line, "Function");
    }
    
    public static void ensureNewNodeSTentryIsPresent(HashMap<String, STentry> map, String id, int line) {
        if (!map.containsKey(id)) {
            fail("Id: " + id + " at line " + line + " not declared");
        }
    }
    
    public static STentry getIDFromSymbolTable(ArrayList<HashMap<String, STentry>> symTable, String id,
            int nestingLevel, int line) {
        for (int i = nestingLevel; i >= 0; i--) {
            if (symTable.get(i).containsKey(id)) {
                return symTable.get(i).get(id);
            }
        }
        fail("Id: " + id + " at line " + line + " not declared");
        return null;
    }
    
    private static void addSTentryToSymbolTable(HashMap<String, STentry> map, String id,
            int nestingLevel, Node type, int offset, int line, String elementType) {
        if ( map.put(id, new STentry(nestingLevel, type, offset)) != null) { 
            fail(elementType + " id: " + id + " at line " + line + " already declared");
        } 
    }
    
    private static void fail(String message) {
        System.out.println(message);
        System.exit(0);
    }
}
