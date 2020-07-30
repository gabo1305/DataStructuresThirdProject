package cr.ac.tec.DataStructures.Tree;


import cr.ac.tec.DataStructures.Stack.Stack;

public interface TreeWayMarker {
    public void addTrace(int data);
    public Stack<Integer> getList();
}
