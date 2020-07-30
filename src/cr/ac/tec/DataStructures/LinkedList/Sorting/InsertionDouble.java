package cr.ac.tec.DataStructures.LinkedList.Sorting;

import cr.ac.tec.DataStructures.LinkedList.Nodes.DoubleNode;

public class InsertionDouble<T extends Comparable>  extends Sorting<T> {




    private DoubleNode FindSort(){
        if(List==null || List.getLength()<=0)return null;
        DoubleNode<T> temp=List.getNode(0);
        while(temp.getFront()!=null && temp.getInfo().compareTo(temp.getFront().getInfo())<0){
            temp=temp.getFront();
        }

        return temp;
    }


    @Override
    public void sort() {
        for(int i=0;i<List.getLength();i++){
            T temp;
            int p=i;
            while(p>0 && List.get(p).compareTo(List.get(p-1))<0){
                temp=List.get(p);
                List.getNode(p).setInfo(List.get(p-1));
                List.getNode(p-1).setInfo(temp);
                p--;
            }
        }
    }

}
