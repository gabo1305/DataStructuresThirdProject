package cr.ac.tec.DataStructures.LinkedList.Search;

import cr.ac.tec.DataStructures.LinkedList.List.List;

public abstract class Searching<T> {
    protected List<T> List;
    final public void setList(List<T> List){
        this.List=List;
    }
    public abstract boolean find(T data);
}
