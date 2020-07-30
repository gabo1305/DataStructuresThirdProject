package cr.ac.tec.DataStructures.Tree;

import cr.ac.tec.DataStructures.LinkedList.Nodes.DoubleNode;


public class SplayTree<T extends Comparable>  extends AVLTree<T>{
    public SplayTree(){
        wayMarker=new SimpleBinaryTreeWayMarker();
    }




    @Override
    public DoubleNode Balance(DoubleNode Node) {
        if(Node==null)return null;
       if(Node.getFront()==null & Node.getBack()==null)return Node;
        int data=wayMarker.getData();
        if(data==1){
           return rotateLeft(Node);
        }
        return rotateRight(Node);
    }
    @Override
    public T get(T data){
        if(data==null)return null;
        wayMarker.clear();
        root=this.getNode(root,data);
        if(root==null)return null;
        return root.getInfo();

    }

    @Override
    public boolean contains(T data) {
        return super.contains(data);
    }


    public void findingMax(DoubleNode<T> node){
        root=findMax(node);
    }

    @Override
    public DoubleNode<T> findMax(DoubleNode<T> node) {
        if(node==null)return null;
        if(node.getFront()==null)return node;
        wayMarker.addTrace(1);
        return findMax(Balance(node.getFront()));
    }
    public void findingMin(DoubleNode<T> node){
        root=findMin(node);
    }

    @Override
    public DoubleNode<T> findMin(DoubleNode<T> node) {
        if(node==null)return null;
        if(node.getBack()==null)return node;
        wayMarker.addTrace(0);
        return findMin(Balance(node.getBack()));

    }
    public DoubleNode<T> deleteMin(){
        this.root=deletingMin(root);
        return root;
    }

    protected DoubleNode<T> deletingMin(DoubleNode<T> node){
       if(node==null)return null;
        return findMin(node).getFront();
    }
    public DoubleNode<T> deleteMax(){
        this.root=deletingMax(root);
        return root;
    }
    protected DoubleNode<T> deletingMax(DoubleNode<T> node){
        if(node==null)return null;
        return findMax(node).getBack();
    }


    @Override
    public void deletion(T data) {
        DoubleNode<T> temp=getNode(root,data);
        if(temp==null)return;
        root=temp;
    }
    @Override
    protected DoubleNode<T> delete(DoubleNode<T> node, T data) {
        DoubleNode<T> temp=getNode(node,data);
        DoubleNode<T> temp2;
        if(temp==null)return root;
        if(temp.getBack()==null && temp.getFront()==null)return null;
        if(temp.getFront()==null){
            return findMin(temp.getFront());
        }
        return findMax(temp.getBack());
    }

}
