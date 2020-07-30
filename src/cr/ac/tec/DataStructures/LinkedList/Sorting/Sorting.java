package cr.ac.tec.DataStructures.LinkedList.Sorting;

import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;

public abstract class Sorting<T extends Comparable> {
    protected DoubleList<T> List;
    /**
     *
     */
    public abstract void sort();

    /**
     *
     * @param List
     */
   final public void setList(cr.ac.tec.DataStructures.LinkedList.List.List<T> List) {
        try{
            this.List=(DoubleList<T>)List;
        }
        catch (Exception e){
            this.List=null;
        }

    }
    protected void Swap(int First, int Second){
        if(First<List.getLength() && Second<List.getLength()){
            T info=List.get(First);
            List.getNode(First).setInfo(List.get(Second));
            List.getNode(Second).setInfo(info);
        }
    }

}
