package cr.ac.tec.DataStructures.LinkedList.List;

import cr.ac.tec.DataStructures.LinkedList.Nodes.SingleListNode;

public class SingleList<T> implements List<T>{
    private SingleListNode<T> head,tail;//The first and last node reference
    int length;//the list length

    /**
     * Create an node'sless list
     */
    public SingleList(){
        head=tail=null;
        length=0;
    }

    /**
     * Add a node at at the first
     * @param NewInfo the info that will be saved into the node
     */
    public void AddHead(T NewInfo){
        head=new SingleListNode<T>(NewInfo,head);
        if(tail==null){
            tail=head;
        }
        length++;
    }

    /**
     *Adds a last node with specified info
     * @param Newinfo the info that will be stored
     */
    public void AddTail(T Newinfo){
        if(!this.isEmpty()) {
            tail.setNextnode(new SingleListNode<T>(Newinfo));
            tail = tail.getNextnode();
        }
        else{
            tail=head=new SingleListNode<T>(Newinfo);
        }
        length++;
    }

    /**
     * Delete the node at the last position
     * @return The info stored in the last node
     */
    public T DeleteFromHead(){
        if(this.isEmpty()){
            return null;
        }
        T info=head.getInfo();
        if(head==tail){
            head=tail=null;
            return info;
        }
        else{
            head=head.getNextnode();
            return info;
        }
    }

    /**
     * Delete the node in the last position, and returns the info stored there
     * @return
     */
    public T DeleteFromTail(){
        if(this.isEmpty()){
            return null;
        }
        T info=tail.getInfo();
        if(tail==head){
            tail=head=null;
            return info;
        }
        else{
            SingleListNode<T> tmp;
            for (tmp=head;tmp.getNextnode()!=tail;tmp=tmp.getNextnode());
            tail=tmp;
            tail.setNextnode(null);
            return info;
        }
    }

    /**
     *Delete a the first node with the specified info
     * @param info the info
     * @return the info, null either
     */
    public T DeleteMiddleNode(T info){
        if(isEmpty()) return null;
        T returning=null;
        if(head==tail){
            if(info==head.getInfo()){
                head=tail=null;
                return info;
            }
            else{
                return null;
            }
        }
        SingleListNode<T> Temp;
        for(Temp=head;Temp.getNextnode().getInfo()!=info;Temp=Temp.getNextnode());
        Temp.setNextnode(Temp.getNextnode().getNextnode());
        return info;
    }

    /**
     *Checks whatever the list its empty or not
     * @return true if its empty, false either
     */
    public boolean isEmpty(){
        boolean returning=false;
        if(head==null){
            returning=true;
        }
        return returning;
    }

    /**
     * Checks if the info its in the list
     * @param info the info
     * @return true if the info its on the list, false either way
     */
    public boolean inList(T info){
        boolean returning=false;
        if(head==null){
            return false;
        }
        SingleListNode<T> temp;
        for(temp=head;temp!=null && !returning;temp=temp.getNextnode()){
            if(temp.getInfo()==info) returning=true;
        }
        return returning;
    }

    /**
     * prints each node info starting with the head
     */
    public void printing(){
        SingleListNode<T> temp;
        for(temp=head;temp!=null;temp=temp.getNextnode()){


        }
    }

    /**
     * Gets the information into a specified position
     * @param position The position in the list
     * @return The info in the specified position
     */
    public T get(int position){
        if(position>-1 && position<length){
            if(position==0)return head.getInfo();
            if(position==length-1)return tail.getInfo();
            SingleListNode<T> temp=head.getNextnode();
            for(int i=1;i!=position;i++){
                temp=temp.getNextnode();
            }
            return temp.getInfo();
        }
        else return null;
    }
    private SingleListNode<T> getNode(int position){
        if(position>-1 && position<length){
            if(position==0)return head;
            if(position==length-1)return tail;
            SingleListNode<T> temp=head.getNextnode();
            for(int i=1;i!=position;i++){
                temp=temp.getNextnode();
            }
            return temp;
        }
        else return null;
    }

    /**
     * Erase a node in the specified position
     * @param position the position
     */
    public void delete(int position){
        if(position>-1 && position<length){
            if(position==0)this.DeleteFromHead();
            else if(position==length-1)this.DeleteFromTail();
            else{
                SingleListNode<T> temp=head;
                for(int i=0;i!=position-1;i++){
                    temp=temp.getNextnode();
                }
                temp.setNextnode(temp.getNextnode().getNextnode());
                length--;
            }
        }
    }

    /**
     *
     * @param position
     * @param content
     */
    @Override
    public void ChangeContent(int position, T content) {
        if(position>=0 && position<length) {
            SingleListNode<T> Temp = getNode(position);
            Temp.setInfo(content);
        }
    }

    /**
     * Finds the position of the first node that has the value provided
     * @param value  The info to be ckecked
     * @return the position if found, -1 if not
     */
    public int FindFirstInstancePosition(T value){
        if(!this.isEmpty()){
            SingleListNode<T> temp;
            int i=-1;
            for(temp=head;temp.getNextnode()!=null;temp=temp.getNextnode()){
                i++;
                if(temp.getInfo()==value)return i;
            }
            if(tail.getInfo()==value)return length-1;
        }
        return -1;
    }

    /**
     * Gets the list length's
     * @return the list's length
     */
    public int getLength(){
        return length;
    }
}
