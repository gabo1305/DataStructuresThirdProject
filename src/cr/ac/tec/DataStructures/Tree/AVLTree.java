package cr.ac.tec.DataStructures.Tree;


import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;
import cr.ac.tec.DataStructures.LinkedList.Nodes.DoubleNode;


public class AVLTree<T extends Comparable > extends BinaryTree<T> {
    private final int AllowedUnbalance=1;
    public AVLTree(){
        super();
    }

    @Override
    public DoubleNode<T> Balance(DoubleNode<T> Node) {
        if(Node==null) return Node;
        int right=getHeight(Node.getFront());
        int left=getHeight(Node.getBack());
        int difference =right-left;
        if(Math.abs(difference)<=AllowedUnbalance)return Node;
        DoubleNode<T> reference;
        if(difference<0){
            reference=Node.getBack();
            if(getHeight(reference.getFront())-getHeight(reference.getBack())>0){
                Node.setBack(rotateLeft(reference));
            }
            reference=rotateRight(Node);

        }
        else{
            reference=Node.getFront();
            if(getHeight(reference.getFront())-getHeight(reference.getBack())<0){
                Node.setFront(rotateRight(reference));
            }
            reference=rotateLeft(Node);
        }
        return reference;


    }
    public DoubleNode<T> rotateLeft(DoubleNode<T> node){
        if(node==null)return null;
        DoubleNode<T> reference=node.getFront();
        node.setFront(reference.getBack());
        reference.setBack(node);
        return reference;
    }
    public DoubleNode<T> rotateRight(DoubleNode<T> node){
        if(node==null)return null;
        DoubleNode<T> reference=node.getBack();
        node.setBack(reference.getFront());
        reference.setFront(node);
        return reference;
    }
    public void printingcolumn(){
        DoubleList<DoubleNode<T>> nodeDoubleList=new DoubleList<>();
        nodeDoubleList.AddTail(root);
        printingNodes(nodeDoubleList);
    }
    public void printingNodes(DoubleList<DoubleNode<T>> List){
        if(findNullList(List))return;
        DoubleList<DoubleNode<T>> List2=new DoubleList<>();
        DoubleNode<T> current;
        for(int i=0;i<List.getLength();i++){
            current=List.get(i);
            if(current==null){
                System.out.print("null");
                List2.AddTail(null);
                List2.AddTail(null);
            }
            else{
                System.out.print(current.getInfo());
                List2.AddTail(current.getBack());
                List2.AddTail(current.getFront());
            }
            System.out.println("");
        }
        System.out.println("--------------------------------------------------------------");
        printingNodes(List2);


    }
    public boolean findNullList(DoubleList<DoubleNode<T>> List){
        for(int i=0;i<List.getLength();i++){
            if(List.get(i)!=null)return false;
        }
        return true;
    }
}
