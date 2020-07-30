package cr.ac.tec.DataStructures.Stack;

import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;

/**
 * This class defines the stack
 * @author Andrey Zuñiga
 * @param <T>
 */

public class Stack<T> {
    private DoubleList<T> reference;

    /**
     *The constructor
     * @author Andrey Zuñiga
     */
    public Stack(){
        reference=new DoubleList<>();
    }

    /**
     * Adds an element in the last position
     * @author Andrey Zuñiga
     * @param content element that is added
     */
    public void push(T content){
        reference.AddHead(content);
    }

    /**
     * Gets the last item and removes it
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
     * show the stack
     * @author Andrey Zuñiga
     * @return
     */
    public T view(){
        if(!reference.isEmpty()){
            return reference.get(0);
        }
        return null;
    }



    /**
     * The method checks if it is empty
     * @author Andrey Zuñiga
     * @return boolean true or false
     */
    public boolean isEmpty(){
        if (reference.isEmpty())return true;
        return false;
    }
    public void printing(){
        reference.printingB();
    }

}
