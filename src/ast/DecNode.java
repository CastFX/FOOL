package ast;

/**
 * 
 * @author Maicol Interface implemented by VarNode, FunNode, ParNode. ( High
 *         Order Extension )
 */
public interface DecNode {

    /**
     * 
     * @return the type that is in the symbol table.
     */
    Node getSymType();
}
