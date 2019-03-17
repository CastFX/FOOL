package ast;

/**
 * 
 *  Interfaccia che viene implementata da VarNode, FunNode e ParNode. ( Higher Order Extension )
 */
public interface DecNode {

    /**
     * 
     * @return il tipo messo in Symbol table.
     */
    Node getSymType();
}
