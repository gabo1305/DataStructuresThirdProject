package cr.ac.tec.DataStructures.LinkedList.List;

import cr.ac.tec.DataStructures.LinkedList.Nodes.DoubleNode;
import cr.ac.tec.DataStructures.LinkedList.Search.BinarySearch;
import cr.ac.tec.DataStructures.LinkedList.Search.Searching;
import cr.ac.tec.DataStructures.LinkedList.Sorting.InsertionDouble;

public class Set<T extends Comparable>extends ComparableDoubleList<T> {
    Searching<T> searching;
    public Set(Searching<T> searching){
        super();
        super.setSortingMethod(new InsertionDouble<T>());
       if(searching==null)searching=new BinarySearch<T>();
       this.searching=searching;
        this.searching.setList(this);
    }

    @Override
    public void AddTail(T Newinfo) {
       sort();
        if(Newinfo==null)return;
        boolean v=inList(Newinfo);
        if(inList(Newinfo))return;
        if(head==null){
            head=tail=new DoubleNode<T>(Newinfo);
        }
        else {
            DoubleNode<T> temp=new DoubleNode<>(Newinfo);
            tail.setFront(temp);
            temp.setBack(tail);
            tail=temp;

        }
        sort();
        length++;
    }

    @Override
    @Deprecated
    public void AddHead(T NewInfo) {
        return;
    }

    @Override
    public boolean inList(T info) {
       return searching.find(info);
    }
}
