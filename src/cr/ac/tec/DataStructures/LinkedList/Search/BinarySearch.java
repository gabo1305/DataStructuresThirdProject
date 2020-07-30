package cr.ac.tec.DataStructures.LinkedList.Search;

public class BinarySearch<T extends Comparable> extends Searching<T> {

    @Override
    public boolean find(T data) {
        if(List==null || List.isEmpty())return false;
        final int init=0;
        final int finish=List.getLength();
        return getting(data,init,finish);
    }
    private boolean getting(T data, int init, int finish){

        if(finish-init==1)return data.compareTo(List.get(init))==0;
        int middle=((finish-init)/2)+init;
        T data2= List.get(middle);
        if(data.compareTo(data2)==0)return true;
        if(data.compareTo(data2)>0)return getting(data,middle,finish);
        else return getting(data,init,middle);
    }
}
