package cr.ac.tec.DataStructures.LinkedList.List;

import cr.ac.tec.DataStructures.LinkedList.Sorting.Sorting;

/**
 *
 * @param <T>
 */
public class ComparableDoubleList<T extends Comparable> extends DoubleList<T> {
    private Sorting sortingMethod;

    /**
     *
     */
    public ComparableDoubleList(){
        super();
    }

    /**
     *
     */
    public void sort(){
        if(sortingMethod!=null) {
            sortingMethod.sort();
        }
    }

    /**
     *
     * @param sortingMethod
     */
    public void setSortingMethod(Sorting sortingMethod){
        this.sortingMethod=sortingMethod;
        this.sortingMethod.setList(this);
    }
}
