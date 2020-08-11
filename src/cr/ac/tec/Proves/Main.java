package cr.ac.tec.Proves;

import com.google.gson.internal.bind.util.ISO8601Utils;
import cr.ac.tec.DataStructures.Array.ArrayTools;
import cr.ac.tec.DataStructures.Graphs.Graph;
import cr.ac.tec.DataStructures.Graphs.GraphsAlgorithm.Dijkstra;
import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;

import java.util.Calendar;
import java.util.Date;

public class Main {
    private static String A="A";
    private static String B="B";
    private static String C="C";
    private static String D="D";
    private static String E="E";
    private static String F="F";
    private static String G="G";
    public static void main(String[] args) {
        DoubleList<String> List=new DoubleList<>();
        List.AddTail(A);
        List.AddTail(B);
        List.AddTail(C);
        List.AddTail(D);
        List.AddTail(E);
        List.AddTail(F);
        Graph<String> graph=new Graph<>(List);
        graph.AddRelationShip(A,C,40);
        graph.AddRelationShip(A,F,62);
        graph.AddRelationShip(B,A,102);
        graph.AddRelationShip(B,E,33);
        graph.AddRelationShip(C,A,50);
        graph.AddRelationShip(C,B,44);
        graph.AddRelationShip(C,D,60);
        graph.AddRelationShip(D,C,73);
        graph.AddRelationShip(E,B,45);
        graph.AddRelationShip(F,B,45);
        graph.AddRelationShip(F,E,98);
        graph.AddNode(G);
        graph.AddNode("H");
        graph.AddRelationShip(D,G,90);
        Dijkstra<String> dijkstra=new Dijkstra<>();
        dijkstra.setGraph(graph);
        DoubleList<String> NList=dijkstra.getShortestRoute(E,D);
        Calendar calendar=Calendar.getInstance();
        Date date=new Date();
        //date.
       // System.out.println(date);
    }
}
