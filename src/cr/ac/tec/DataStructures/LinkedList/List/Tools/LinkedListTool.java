package cr.ac.tec.DataStructures.LinkedList.List.Tools;

import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;

import java.util.ArrayList;

public class LinkedListTool<T> {
    public  DoubleList<T> Merge(DoubleList<T>...Lists){
        DoubleList<T> returning=new DoubleList<>();
        DoubleList<T> List;
        if(Lists!=null) {
            for (int i = 0; i < Lists.length; i++) {
                List = Lists[i];
                for (int j = 0; j < List.getLength(); j++) {
                    returning.AddTail(List.get(j));
                }
            }
        }
        return returning;
    }
    public static DoubleList<String> toStringList(DoubleList List){
        if(List==null)return null;
        DoubleList<String> returning=new DoubleList<>();
        if(List!=null) {
            for (int i = 0; i < List.getLength(); i++) {
                returning.AddTail(List.get(i).toString());
            }
        }
        return returning;
    }
    public static String[] getArray(DoubleList<String> List){
        if(List==null)return null;
        String[] array=new String[List.getLength()];
        for(int i=0;i<List.getLength();i++){
            array[i]=List.get(i);
        }
        return array;
    }
    public static void appendString(DoubleList<String>List ,String[] array){
        if(List==null || array==null)return;
        for(int i=0;i<array.length;i++){
            List.AddTail(array[i]);
        }
    }
    public ArrayList<T> toJavaList(DoubleList<T> List){
        if(List==null)return null;
        ArrayList<T> arrayList=new ArrayList<>();
        for(int i=0;i<List.getLength();i++){
            arrayList.add(List.get(i));
        }
        return arrayList;
    }
    public DoubleList<T> tDoubleList(ArrayList<T> arrayList){
        if(arrayList==null)return null;
        DoubleList<T> List=new DoubleList<>();
        for(int i=0;i<arrayList.size();i++){
            List.AddTail(arrayList.get(i));
        }
        return List;
    }

}
