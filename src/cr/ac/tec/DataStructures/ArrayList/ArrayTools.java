package cr.ac.tec.DataStructures.ArrayList;

import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;

import java.util.ArrayList;

public class ArrayTools<T> {
    public void append(ArrayList <T> Source,ArrayList<T> appending ){
        if(Source==null || appending==null)return;
        for(int i=0;i<appending.size();i++){
            Source.add(appending.get(i));

        }

    }
    public DoubleList<T> getDoubleList(T[] array){
        if(array==null)return null;
        DoubleList<T> List=new DoubleList<>();
        for(int i=0;i<array.length;i++){
            List.AddTail(array[i]);
        }
        return List;
    }

}
