package cr.ac.tec.DataStructures.LinkedList.List;

import cr.ac.tec.DataStructures.LinkedList.Nodes.DoubleNode;

public class DoubleList<T> implements List<T> {

    protected DoubleNode<T> head,tail;//The first and last node
    protected int length;// List length

    /**
     * Creates an empty list, without any node
     */
    public DoubleList(){
        head=tail=null;
        length=0;
    }

    /**
     * Adds a node into the first position
     * @param NewInfo the info that will be stored in the node
     */
    public void AddHead(T NewInfo){
       DoubleNode<T> temp=new DoubleNode<>(NewInfo);
       if(head==null){
           head=tail=temp;
       }
       else {
           head.setBack(temp);
           temp.setFront(head);
           head = temp;
       }
       length++;
    }

    /**
     *
     * @param NewInfo
     */
    void AddHeadNode(DoubleNode<T> NewInfo){
        DoubleNode<T> temp=NewInfo;
        if(head==null){
            head=tail=temp;
        }
        else {
            head.setBack(temp);
            temp.setFront(head);
            head = temp;
        }
        length++;
    }

    /**
     * Adds a node in the las position
     * @param Newinfo the info that'll be stored in the node
     */
    public void AddTail(T Newinfo){
        DoubleNode<T> temp=new DoubleNode<T>(Newinfo);
        if(head==null){
            head=tail=temp;
        }
        else {
            tail.setFront(temp);
            temp.setBack(tail);
            tail=temp;
        }
        length++;

    }

    /**
     *
     * @param Newinfo
     */
     void AddTailNode(DoubleNode<T> Newinfo){
        DoubleNode<T> temp=Newinfo;
        if(head==null){
            head=tail=temp;
        }
        else {
            tail.setFront(temp);
            temp.setBack(tail);
            tail=temp;
        }
        length++;
    }

    /**
     * Deletes the first node a return the info stores the
     * @return info stored in the first node
     */
    public T DeleteFromHead(){
        if(this.isEmpty()){
            return null;
        }
        T info=head.getInfo();
        if(head==tail){
            head=tail=null;
            length--;
            return info;
        }
        else{
            head=head.getFront();
            head.setBack(null);
            length--;
            return info;
        }
    }

    /**
     * Delete the first node and return the info stored there
     * @return the info stored in the last node
     */
    public T DeleteFromTail(){
        if(this.isEmpty()){
            return null;
        }
        T info=tail.getInfo();
        if(tail==head){
            tail=head=null;
            length--;
            return info;
        }
        else{
            tail=tail.getBack();
            tail.setFront(null);
            length--;
            return info;
        }
    }

    /**
     * Looks if the list its empty
     * @return true if the list its empty, false either
     */
    public boolean isEmpty(){
        if(head==null){
            return true;
        }
        return false;
    }

    /**
     * Checks if there's a node with the info
     * @param info the info to be checked in the list
     * @return true if the info its in the list, false either
     */
    public boolean inList(T info){
        boolean returning=false;
        if(head==null)return returning;
        DoubleNode<T> temp;
        boolean flag=true;
        for(temp=head;temp.getFront()!=null && flag; temp=temp.getFront()){
            if(temp.getInfo()==info)flag=false;
        }
        if(!flag || tail.getInfo()==info)returning=true;
        return returning;
    }

    /**
     * prints every node's info
     */
    public void printing(){
        DoubleNode<T> Temp;
        for(Temp=head;Temp.getFront()!=null;Temp=Temp.getFront()){

        }

    }

    /**
     * Deletes a node in a specified position
     * @param position the position to be deleted
     */
    public void delete(int position){
        if(position>-1 && position<length){
            if(position==0)this.DeleteFromHead();
            else if(position==length-1)this.DeleteFromTail();
            else {
                DoubleNode<T> temp = head.getFront();
                for (int i = 1; i < position; i++) {
                    temp = temp.getFront();
                }
                temp.getBack().setFront(temp.getFront());
                temp.getFront().setBack(temp.getBack());
                length--;
            }
        }
    }

    /**
     * Gets the first apperence's position in the list
     * @param value
     * @return
     */
    public int FindFirstInstancePosition(T value){
        if(!this.isEmpty()){
            DoubleNode<T> temp;
            temp=head;
            for(int i=0;i<length;i++){
                try{
                    if(temp.getInfo()==value)return i;
                }
                catch (Exception e){
                    if(temp.getInfo().equals(value))return i;
                }
                temp=temp.getFront();
            }
        }
        return -1;
    }

    /**
     * Gets the node's info into a specific position
     * @param position the position
     * @return The info its the position exist, null either
     */
    public T get(int position){
        if(position>-1 && position<length){
            if(position==0)return head.getInfo();
            if(position==length-1)return tail.getInfo();
            DoubleNode<T> temp=head.getFront();
            for(int i=1;i!=position;i++){
                temp=temp.getFront();
            }
            return temp.getInfo();
        }
        return null;
    }

    /**
     *
     * @param position
     * @return
     */
    public DoubleNode<T> getNode(int position){
        if(position>-1 && position<length){
            if(position==0)return head;
            if(position==length-1)return tail;
            DoubleNode<T> temp=head.getFront();
            for(int i=1;i!=position;i++){
                temp=temp.getFront();
            }
            return temp;
        }
        return null;
    }

    /**
     *
     * @param position
     * @param content
     */
    @Override
    public void ChangeContent(int position, T content) {
        if(position>=0 && position<length){
            DoubleNode<T> temp=getNode(position);
            temp.setInfo(content);
        }
    }

    /**
     * prints every node
     */
    public void printingB(){
        if(length<=0)return;
        DoubleNode<T> Temp;
        for(Temp=tail;Temp.getBack()!=null;Temp=Temp.getBack()){
            System.out.println(Temp.getInfo());
        }
        System.out.println(head.getInfo());

    }

    /**
     * Returns the list's length
     * @return The list's length
     */
    public int getLength(){
        return length;
    }
    public void clear(){
        this.head=this.tail=null;
        this.length=0;
    }
    public void appendList(DoubleList<T> List){
        if(List==null || List.getLength()<=0)return;
        for(int i=0;i<List.getLength();i++){
            AddTail(List.get(i));
        }

    }
    public void appendArray(T[] array){
        if(array==null || array.length<=0)return;
        for(int i=0;i<array.length;i++){
            AddTail(array[i]);
        }
    }


}
