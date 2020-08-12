package cr.ac.tec.DataStructures.LinkedList.Nodes;

/**
 * @author Andrey Zuniga
 * @param <T>
 */
public class SingleListNode<T> {
    private T info;// Node's content
    private SingleListNode<T> Nextnode;//Next Node reference

    public SingleListNode(){
        this(null,null);

    }

    /**
     *
     * @param container Info to be saved in node
     * @param Reference A reference to the next node
     */
    public SingleListNode(T container, SingleListNode<T> Reference){
        info=container;
        Nextnode=Reference;
    }

    /**
     * This sets the field info as the provided info, and the node reference to null
     * @param container The info to be stored in the node
     */
    public SingleListNode(T container){
        this(container,null);
    }

    /**
     * Changes the info stored in the node
     * @param info The new info
     */
    public void setInfo(T info) {
        this.info = info;
    }//Changes the node info

    /**
     * Changes the reference node
     * @param nextnode the new node to be reffered to
     */
    public void setNextnode(SingleListNode<T> nextnode) {
        Nextnode = nextnode;
    }

    /**
     * Returns the info stored in the node
     * @return The info stored, the type depends the setted node's type
     */
    public T getInfo() {
        return info;
    }

    /**
     * Return the node that's referred by the actual node
     * @return A node
     */
    public SingleListNode<T> getNextnode() {
        return Nextnode;
    }
}
