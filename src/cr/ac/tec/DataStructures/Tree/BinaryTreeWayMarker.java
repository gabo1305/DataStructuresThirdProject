package cr.ac.tec.DataStructures.Tree;

import cr.ac.tec.DataStructures.Stack.Stack;


public abstract class BinaryTreeWayMarker implements TreeWayMarker {
    final int limit=2;
    protected Stack<Integer> Stack;
    @Override
    public Stack<Integer> getList() {
        return Stack;
    }
    public boolean verification(int data){
        if(data<=0)return false;
        if(data>=limit)return false;
        return true;
    }
    public final void clear(){
        Stack=new Stack<>();
    }
    public int getData(){
        if(Stack.isEmpty())return -1;
        return Stack.pop();
    }
    public Stack<Integer> getStack(){
        return Stack;
    }

}
