package cr.ac.tec.DataStructures.LinkedList.Sorting;

public class QuickSort<T extends Comparable> extends Sorting<T> {
    @Override
    public void sort() {
        if(List==null)return;
        final int a=0;
        final int b=List.getLength();
        sorting(a,b);
    }
    private void sorting(int init, int finish){
       if(List==null || finish>List.getLength() ||init>List.getLength() || finish-init<2 || init>finish)return;
       int index=init+((finish-init)/2);
       T pivot= List.get(index);
       int i=init;
       int j=finish-1;
       while(j>=i){
          while(List.get(i).compareTo(pivot)<0){
              i++;
          }
          while(List.get(j).compareTo(pivot)>0){
              j--;
          }
          if(i<=j){
              Swap(i,j);
              i++;
              j--;
          }
       }
       if(init<j){
           sorting(init,i);
       }
      if(i<finish) {
          sorting(i, finish);
      }
    }
}
