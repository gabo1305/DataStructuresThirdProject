package cr.ac.tec.Proves;

import cr.ac.tec.DataStructures.Graphs.Graph;
import cr.ac.tec.DataStructures.Graphs.GraphsAlgorithm.Dijkstra;
import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;

public class Main {
    private static String A="A";
    private static String B="B";
    private static String C="C";
    private static String D="D";
    private static String E="E";
    private static String F="F";
    private static String G="G";
    public static void main(String[] args) {
        DoubleList<String> nodes=new DoubleList<String>();
        nodes.AddTail(A);
        nodes.AddTail(B);
        nodes.AddTail(C);
        nodes.AddTail(D);
        nodes.AddTail(E);
        nodes.AddTail(F);
        Graph<String> graph=new Graph<String>(nodes);
        graph.AddRelationShip(A,B,50);
        graph.AddRelationShip(A,C,30);
        graph.AddRelationShip(B,D,90);
        graph.AddRelationShip(C,A,45);
        graph.AddRelationShip(E,F,100);
        graph.AddRelationShip(E,A,120);
        graph.AddRelationShip(F,D,40);
        Dijkstra<String> finder=new Dijkstra<String>();
        finder.setGraph(graph);
        DoubleList<String> route=finder.getShortestRoute(E,B);
        double price=finder.getPrice(E,B);
        System.out.println("El precio es "+price);
        for(int i=0;i<route.getLength();i++){
            System.out.println(route.get(i));
        }

    }
}
