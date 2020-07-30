package cr.ac.tec.DataStructures.Tree;

import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;
import cr.ac.tec.DataStructures.LinkedList.Nodes.DoubleNode;

import java.util.ArrayList;


public class BinaryTree<T extends Comparable> implements Balancer<T> {
    protected DoubleNode<T> root;
    protected BinaryTreeWayMarker wayMarker;
    final boolean isEmpty(){
       return root==null;
    }
    public BinaryTree(){
        wayMarker=new NullBinaryTreeWayMarker();
    }
    public boolean contains(T data){
        return getNode(root,data)!=null;

    }
     protected DoubleNode<T> getNode(DoubleNode<T> node,T data){
        if(node==null || node.getInfo().compareTo(data)==0){
            return node;
        }
         DoubleNode<T> temp;
        if(data.compareTo(node.getInfo())>0){
            wayMarker.addTrace(1);
            temp= getNode(node.getFront(),data);
        }
        else {
            wayMarker.addTrace(0);
            temp= getNode(node.getBack(),data);
        }
        return Balance(temp);

    }
    public void insertion(T data){
        wayMarker.clear();
        this.root=insertions(root,data);

    }
     public T get(T data){
        if(data==null)return null;
        DoubleNode<T> returning =this.getNode(root,data);
        if(returning==null)return null;
        return returning.getInfo();

    }
    protected DoubleNode<T> insertions(DoubleNode<T> current, T data){
        DoubleNode<T> node;
        if(current==null)return new DoubleNode<T>(data);
        if(data.compareTo(current.getInfo())==0)return current;
        boolean condition=data.compareTo(current.getInfo())>0;
        if(condition){
            current.setFront(insertions(current.getFront(),data));
            wayMarker.addTrace(1);
        }
        else{
            current.setBack(insertions(current.getBack(),data));
            wayMarker.addTrace(0);
        }

        return Balance(current);
    }
     public void deletion(T data){
        wayMarker.clear();
        this.root=delete(root,data);

    }
    protected DoubleNode<T> delete(DoubleNode<T> node,T data){
        if(node==null)return null;
        if(data.compareTo(node.getInfo())>0){
            node.setFront(delete(node.getFront(),data));
            wayMarker.addTrace(1);
        }
        else if(data.compareTo(node.getInfo())<0){
            node.setBack(delete(node.getBack(),data));
            wayMarker.addTrace(0);
        }
        else if(node.getBack()==null && node.getFront()==null){
            node=null;
        }
        else {
            DoubleNode<T> temp;
            T info;
            if(node.getFront()!=null){
                temp=findMin(node.getFront());
                info=temp.getInfo();
                node.setFront(delete(node.getFront(),info));

            }
            else {
                temp=findMax(node.getBack());
                info=temp.getInfo();
                node.setBack(delete(node.getBack(),info));
            }

            node.setInfo(temp.getInfo());
        }
        return Balance(node);



    }
    public DoubleNode<T> findMin(DoubleNode<T> node){
        if(node==null)return null;
        while(node.getBack()!=null){
            node=node.getBack();
        }
        return node;
    }
    public DoubleNode<T> findMax(DoubleNode<T> node){
        if(node==null)return null;
        while(node.getFront()!=null){
            node=node.getFront();
        }
        return node;
    }
    public DoubleNode<T> getRoot(){
        return root;
    }
    public DoubleList<T> getListInOrder(){
        DoubleList<T> List=new DoubleList<>();
        gettingListInOrder(List,root);
        return List;
    }
    private void gettingListInOrder(DoubleList<T> List,DoubleNode<T> Node){
        if(Node==null)return;
        gettingListInOrder(List,Node.getBack());
        List.AddTail(Node.getInfo());
        gettingListInOrder(List,Node.getFront());
    }
    public DoubleList<T> getListPreOrder(){
        DoubleList<T> List=new DoubleList<>();
        gettingListPreOrder(List,root);
        return List;

    }
    private void gettingListPreOrder(DoubleList<T> List, DoubleNode<T> node){
        if(node==null)return;
        List.AddTail(node.getInfo());
        gettingListPreOrder(List,node.getBack());
        gettingListPreOrder(List,node.getFront());
    }
    public DoubleList<T> getListPostOrder(){
        DoubleList<T> List= new DoubleList<>();
        gettingPostOrder(List,root);
        return List;

    }
    private void gettingPostOrder(DoubleList<T> List, DoubleNode<T> node){
        if(node==null)return;
        gettingPostOrder(List,node.getBack());
        gettingPostOrder(List,node.getFront());
        List.AddTail(node.getInfo());
    }
    public ArrayList<T> getArrayList(){
        DoubleList<T> tDoubleList=getListInOrder();
        ArrayList<T> arrayList=new ArrayList<>();
        for(int i=0;i<tDoubleList.getLength();i++){
            arrayList.add(tDoubleList.get(i));
        }
        return arrayList;
    }
    public int getHeight(){
        return getHeight(root);
    }

    protected  int getHeight(DoubleNode<T> Node){
        if(Node==null) return 0;
        int RightHeight=getHeight(Node.getFront());
        int LeftHeight=getHeight(Node.getBack());
        if(LeftHeight>RightHeight)return LeftHeight+1;
        return 1+RightHeight;
    }


    @Override
    public DoubleNode<T> Balance(DoubleNode<T> Node) {
        return Node;
    }
    public boolean inTree(T data){
        return inTree(root,data);

    }
    private boolean inTree(DoubleNode<T> Node,T data){
        if(Node==null)return false;
        int value=data.compareTo(Node.getInfo());
        if (value==0)return true;
        if(value>0)return inTree(Node.getFront(),data);
        return inTree(Node.getBack(),data);
    }
    public void append(DoubleList<T> List){
        if(List==null)return;
        for(int i=0;i<List.getLength();i++){
            this.insertion(List.get(i));
        }
    }
    public void append(T[] array){
        if(array==null)return;
        for(int p=0;p<array.length;p++){
            this.insertion(array[p]);
        }

    }

}
