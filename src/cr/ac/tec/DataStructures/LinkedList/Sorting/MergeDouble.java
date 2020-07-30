package cr.ac.tec.DataStructures.LinkedList.Sorting;

import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;

public class MergeDouble<T extends Comparable> extends Sorting<T> {
    @Override
    public void sort() {
        if(List==null)return;
        final int init=0;
        final int finish=List.getLength();
        sorting(init,finish);

    }
    private void sorting(int init, int finish){
        if(List==null || finish-init<2)return;
        int middle=((finish-init)/2)+init;
        sorting(init,middle);
        sorting(middle,finish);
        merge(init,middle,finish);
    }
    private void merge(int init , int middle , int finish){
        DoubleList<T> temp=new DoubleList<>();
        int i=init;
        int j=middle;
        while(i<middle && j<finish){
            if(List.get(i).compareTo(List.get(j))<0){
                temp.AddTail(List.get(i));
                i++;
            }
            else {
                temp.AddTail(List.get(j));
                j++;
            }
        }
        while(i<middle){
            temp.AddTail(List.get(i));
            i++;
        }
        while(j<finish){
            temp.AddTail(List.get(j));
            j++;
        }
        for(int p=0;p<temp.getLength();p++){
            List.getNode(p+init).setInfo(temp.get(p));
        }

    }
}
