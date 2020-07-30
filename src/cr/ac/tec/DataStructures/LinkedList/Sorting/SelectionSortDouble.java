package cr.ac.tec.DataStructures.LinkedList.Sorting;

import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;
import cr.ac.tec.DataStructures.LinkedList.Nodes.DoubleNode;

public class SelectionSortDouble<T extends Comparable> extends Sorting<T> {
    @Override
    public void sort() {
        if(List!=null && List.getLength()>0){
            int min;
            for(int i=0;i<List.getLength();i++){                                                    min=getMin(List,i);
                Swap(i,min);
            }

        }

    }



   private int getMin(DoubleList<T> toGet,int pos){
        if(toGet==null || toGet.getLength()<=0 || pos>=toGet.getLength())return -1;
        int p=pos;
        DoubleNode<T> temp=toGet.getNode(pos);
        for(int i=pos;i<toGet.getLength();i++){
            if(toGet.get(i).compareTo(temp.getInfo())<0){
                p=i;
                temp=toGet.getNode(i);
            }
        }
        return p;
    }



}
