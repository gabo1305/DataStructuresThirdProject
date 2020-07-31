package cr.ac.tec.DataStructures.Graphs;

import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;

public class NonWeightGraph<T> extends Graph<T>  {
    private final int weight=1;
    public NonWeightGraph(DoubleList<T> List) {
        super(List);
    }

    @Override
    public void AddRelationShip(T Node1, T Node2, int weight) {
        super.AddRelationShip(Node1,Node2,weight);
    }
}
