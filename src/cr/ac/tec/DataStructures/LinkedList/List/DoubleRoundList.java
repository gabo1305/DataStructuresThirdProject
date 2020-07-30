package cr.ac.tec.DataStructures.LinkedList.List;

import cr.ac.tec.DataStructures.LinkedList.Nodes.DoubleNode;

public class DoubleRoundList<T> implements List<T> {
    private DoubleNode<T> head,tail;//The first and last node reference
    int length;//the list's length

    /**
     * Create a list with no node, an empty list
     */
    public DoubleRoundList(){
        head=tail=null;
        length=0;
    }

    /**
     * Adds a node into the first position, with the specified info
     * @param NewInfo The info stored im the node
     */
    public void AddHead(T NewInfo){
       DoubleNode<T> temp=new DoubleNode<>(NewInfo);
       if(head==null){
           temp.setBack(temp);
           temp.setFront(temp);
           head=tail=temp;
       }
       else {
           head.setBack(temp);
           temp.setFront(head);
           temp.setBack(tail);
           tail.setFront(temp);
           head = temp;
       }
       length++;
    }

    /**
     * Add a new node in the last position
     * @param Newinfo the info that'll stored in the node
     */
    public void AddTail(T Newinfo){
        DoubleNode<T> temp=new DoubleNode<T>(Newinfo);
        if(head==null){
            temp.setFront(temp);
            temp.setBack(temp);
            head=tail=temp;
        }
        else {
            tail.setFront(temp);
            temp.setBack(tail);
            temp.setFront(head);
            head.setBack(temp);
            tail=temp;
        }
        length++;

    }
    public void AddMid(T NewInfo,int pos){
        if(pos==0){
            AddHead(NewInfo);
        }
        else if(pos==length){
            AddTail(NewInfo);
        }
        else if(pos>0 && pos<length){
            DoubleNode<T> temp=head;
            pos--;
            while(pos>0){
                temp=temp.getFront();
            }
            DoubleNode<T> NewNode=new DoubleNode<>(NewInfo,null,null);
            NewNode.setBack(temp);
            NewNode.setFront(temp.getFront());
            temp.getFront().setBack(NewNode);
            temp.setFront(NewNode);
        }
    }

    /**
     * Delete the node in the first position
     * @return the info stored in the node
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
            head.setBack(tail);
            length--;
            return info;
        }
    }

    /**
     * Delete the last node
     * @return The info stored in the last node
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
            tail.setFront(head);
            length--;
            return info;
        }
    }

    /**
     * Checks whatever the list its empty or not
     * @return true its it empty , false either
     */
    public boolean isEmpty(){
        boolean returning=false;
        if(head==null){
            returning=true;
        }
        return returning;
    }

    /**
     * Checks if there's a node in the list with the specified info
     * @param info the info to be checked
     * @return true if the info was finded , false either way
     */
    public boolean inList(T info){
        boolean returning=false;
        if(head==null)return returning;
        DoubleNode<T> temp;
        boolean flag=true;
        for(temp=head;temp.getFront()!=head && flag; temp=temp.getFront()){
            if(temp.getInfo()==info)flag=false;
        }
        if(!flag || tail.getInfo()==info)returning=true;
        return returning;
    }

    /**
     * prints each node's info starting from the head
     */
    public void printing(){
        DoubleNode<T> Temp;
        for(Temp=head;Temp.getFront()!=head;Temp=Temp.getFront()){

        }

    }

    /**
     * prints  each node's info , staring from the tail
     */
    public void printingB(){
        DoubleNode<T> Temp;
        for(Temp=tail;Temp.getBack()!=null;Temp=Temp.getBack()){

        }

    }

    /**
     * print each node's info starting form the head , and keep it forever
     */
    public void printing8(){
        DoubleNode<T> Temp=head;
        while(true){
            System.out.println(Temp.getInfo());
            Temp=Temp.getFront();
        }
    }

    /**
     * Gets the info into a specified position
     * @param position the position
     * @return the position stored in the position if was found
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
     * Deletes a node into an specified position
     * @param position the position to be erased
     */
    public void delete(int position){
        if(position>-1 && position<length){
            if(position==0)this.DeleteFromHead();
            else if(position==length-1)this.DeleteFromTail();
            else {
                DoubleNode<T> temp = head.getFront();
                for (int i = 1; i != position; i++) {
                    temp = temp.getFront();
                }
                temp.getBack().setFront(temp.getFront());
                temp.getFront().setBack(temp.getBack());
                length--;
            }
        }
    }

    /**
     * Finds the first appearance int the list
     * @param value The value to be ckecked
     * @return the position, or -1, if its not in the list
     */
    public int FindFirstInstancePosition(T value){
        if(!this.isEmpty()){
            DoubleNode<T> temp;
            int i=-1;
            for(temp=head;temp.getFront()!=head;temp=temp.getFront()){
                i++;
                if(temp.getInfo()==value)return i;
            }
            if(tail.getInfo()==value)return length-1;
        }
        return -1;
    }

    /**
     * Returns the list's length
     * @return the list's length
     */
    public int getLength(){
        return length;
    }

    /**
     *
     * @param List
     * @param Init
     * @param Finish
     * @param condition
     * @return
     */
    public DoubleList<T> Switch(DoubleList<T> List,int Init,int Finish,boolean condition){
        if(List.getLength()>0 && Init>0 && Init<length-1 && Finish>0 && Finish<length-1 && Finish>Init ) {
            DoubleNode<T> nodeinit = getNode(Init);
            DoubleNode<T> nodeFini = getNode(Finish);
            DoubleList<T> temp=new DoubleList<>();
            for(int i=Init+1;i<Finish;i++ ){
                temp.AddTail(this.get(i));
            }
            List.getNode(0).setBack(nodeinit);
            List.getNode(List.getLength()-1).setFront(nodeFini);
            nodeinit.setFront(List.getNode(0));
            if(condition){
                nodeFini.setBack(List.getNode(List.getLength() - 1));
            }
            length=length-(Finish-Init-1)+List.getLength();
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
}
