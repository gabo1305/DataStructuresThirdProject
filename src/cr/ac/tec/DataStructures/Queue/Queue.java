package cr.ac.tec.DataStructures.Queue;

import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;

/**
 * in this class a queue is created
 * @author Andrey Zuñiga
 * @param <T>
 */

public class Queue<T> {
    private DoubleList<T> reference;

    /**
     * Method that defines the queue
     * @author Andrey Zuñiga
     */
    public Queue(){
        reference=new DoubleList<T>();
    }

    /**
     * Adds an element
     * @author Andrey Zuñiga
     * @param content
     */
    public void push(T content){
        reference.AddTail(content);
    }

    /**
     * Gets an item and removes it
     * @author Andrey Zuñiga
     * @return
     */
    public T pop(){
        if(!reference.isEmpty()){
            T temp=reference.get(0);
            reference.delete(0);
            return  temp;
        }
        return null;
    }

    /**
     * Show the queue
     * @author Andrey Zuñiga
     * @return
     */
    public T view(){
        if(!reference.isEmpty()){
            return reference.get(0);
        }
        return null;
    }
    public boolean isEmpty(){
        if(reference==null)return true;
        return reference.getLength()==0;
    }
}
