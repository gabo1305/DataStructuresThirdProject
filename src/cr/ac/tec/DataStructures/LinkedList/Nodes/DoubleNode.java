package cr.ac.tec.DataStructures.LinkedList.Nodes;

public class DoubleNode<T> {
    private T info;//Stored Information
    private DoubleNode<T> Back;//The next node reference
    private DoubleNode<T> Front;//The prior node reference

    /**
     * A constructor that sets the information, and the two nodes references
     * @param info The information to be stored in the node
     * @param Back The prior node reference
     * @param Front The next node reference
     */
    public DoubleNode(T info, DoubleNode<T> Back, DoubleNode<T> Front){
        this.Back=Back;
        this.info=info;
        this.Front=Front;
    }

    /**
     * Its meaningless to create a empty node
     * @deprecated
     */
    public DoubleNode(){
        this(null,null,null);
    }

    /**
     * Set the information in the node, and lets the two references to node in null
     * @param info The information to be stored in the node
     */
    public DoubleNode(T info){
        this(info,null,null);
    }

    /**
     * Sets the information in the node
     * @param info The information to be added in the node
     */
    public void setInfo(T info) {
        this.info = info;
    }

    /**
     * Set the prior node reference
     * @param back A node
     */

    public void setBack(DoubleNode<T> back) {
        Back = back;
    }

    /**
     * Sets the next node reference
     * @param front A node
     */
    public void setFront(DoubleNode<T> front) {
        Front = front;
    }

    /**
     * Gets the stored info
     * @return The stored info
     */
    public T getInfo() {
        return info;
    }

    /**
     * Return the prior node reference
     * @return the prior node reference
     */
    public DoubleNode<T> getBack() {
        return Back;
    }

    /**
     * Returns the next node reference
     * @return the reference to the next node
     */
    public DoubleNode<T> getFront() {
        return Front;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "info=" + info +
                '}';
    }
}
