package cr.ac.tec.DataStructures.LinkedList.Sorting;

public class BubbleSortDouble<T extends Comparable> extends Sorting<T> {

    @Override
    public void sort() {
        if(List!=null && List.getLength()>0){
            int pos=List.getLength()-1;
            while(pos>0){
                T temp;
                for(int i=0;i<pos;i++){
                    if(List.get(i).compareTo(List.get(i+1))>0){
                        temp=List.get(i);
                        List.getNode(i).setInfo(List.get(i+1));
                        List.getNode(i+1).setInfo(temp);
                    }
                }
                pos--;
            }
        }

    }

}
