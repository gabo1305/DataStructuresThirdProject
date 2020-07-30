package cr.ac.tec.DataStructures.LinkedList.Sorting;

public class RadixSort<T extends Numerable> extends Sorting<T>  {
    final int base=10;
    @Override
    public void sort() {
        if(List==null || List.getLength()<=1)return;
        sorting();
        
    }
    public void sorting(){
        int index[];
        int data=1;
        int end=getLimit();
        System.out.println(end);
        int pos;
        while(data<end){
            index=new int[base];
            for(int i=0;i<List.getLength();i++){
                pos=getPosition(data,i);
                System.out.println(pos);
                index[pos]++;
            }
            sumArray(index);
            T[] array=(T[])List.get(0).getArray(List.getLength());
            for(int i=List.getLength()-1;i>=0;i--){
                pos=getPosition(data,i);
                index[pos]--;
                array[index[pos]]=List.get(i);
            }
            List.clear();
            List.appendArray(array);
            data++;

        }

    }
    public int getPosition(int data,int position){
        int pos;
        pos=List.get(position).getNumber()%(int)Math.pow(base,data);
        pos-=List.get(position).getNumber()%Math.pow(base,data-1);
        pos/=(int)Math.pow(base,data-1);
        return pos;

    }
    private int getLimit(){
        int data=0;
        int divisor;
        for(int i=0;i<List.getLength();i++){
           divisor=(int) Math.pow(base,data);
           if((List.get(i).getNumber()/divisor)!=0){
               i=-1;
               data++;
           }
        }
        return data;

    }
    private void sumArray(int[] array){
        if(array==null || array.length<2)return;
        for(int i=1;i<array.length;i++){
            array[i]=array[i]+array[i-1];
        }
    }

}
