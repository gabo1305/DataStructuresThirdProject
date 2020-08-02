package cr.ac.tec.SavedInfo;

import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;
import cr.ac.tec.DataStructures.Tree.BinaryTree;
import cr.ac.tec.FileProccessing.JsonExchange;
import cr.ac.tec.FileProccessing.jsonSource;


import java.util.ArrayList;

public abstract class InfoTree<T extends Comparable> implements jsonSource {
    protected BinaryTree<T> Tree;
    protected   String route;

    public boolean  attach(T info){
        if(info==null)return false;
        if(IsMember(info)) return false;
        Tree.insertion(info);
        updateFile();

        return true;
    }
    public void detach(T info){
        Tree.deletion(info);
        updateFile();
    }
    public boolean IsMember(T Member){
        return Tree.inTree(Member);
    }
    public T getMember(T Member){ return Tree.get(Member); }
    public void updateFile(){
        ArrayList<T> arrayList=Tree.getArrayList();
        for(int i=0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }
        JsonExchange.toJsonFromObject(route,arrayList);
    }
    public boolean fullCheck(T Member){
        T temp=getMember(Member);
        if(temp==null)return false;
        return Member.equals(temp);
    }
    public DoubleList<T> getList(){
        return Tree.getListInOrder();
    }


}
