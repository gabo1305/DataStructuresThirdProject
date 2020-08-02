package cr.ac.tec.Rail;

import cr.ac.tec.DataStructures.ArrayList.ArrayTools;
import cr.ac.tec.DataStructures.Graphs.Graph;
import cr.ac.tec.DataStructures.Graphs.GraphsAlgorithm.Dijkstra;
import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;
import cr.ac.tec.DataStructures.LinkedList.List.Tools.LinkedListTool;
import cr.ac.tec.FileProccessing.JsonExchange;
import cr.ac.tec.Rail.Roads.Stopping;

import java.util.ArrayList;

public class RailGraph {
    private static int StoppingID;
    private final int NullState=0;
    private final String NodesRoute="C:\\Tecnologico de Costa Rica\\Tercer Semestre\\Algoritmos y estructuras\\RailSpot\\JsonFiles\\Nodes.json";
    private final String RelationRoute="C:\\Tecnologico de Costa Rica\\Tercer Semestre\\Algoritmos y estructuras\\RailSpot\\JsonFiles\\RelationNodes.json";
    private Dijkstra<Stopping> dijkstra;
    private Graph<Stopping> graph;
    private DoubleList<Stopping> nodes;
    private static RailGraph instance;
    private RailGraph(){
        graph=new Graph(getNodes());
        graph.setRelationShip(getRoads());
        dijkstra=new Dijkstra<>();
        dijkstra.setGraph(graph);
        nodes=graph.getNodes();
        StoppingID=graph.NodesNumber();
    }
    public static RailGraph getInstance(){
        if(instance==null){
            synchronized (RailGraph.class){
                if(instance==null){
                    instance=new RailGraph();
                }
            }
        }
        return instance;
    }
    private DoubleList<Stopping> getNodes(){
        Stopping[] stopping=(Stopping[])JsonExchange.getObjectFromJson(NodesRoute,Stopping[].class);
        ArrayTools<Stopping> tools=new ArrayTools<>();
        return tools.getDoubleList(stopping);
    }
    private double[][] getRoads(){
        return (double[][])JsonExchange.getObjectFromJson(RelationRoute,double[][].class);
    }
    public void AddRelationShip(Stopping Init, Stopping End,int weight){
        graph.AddRelationShip(Init,End,weight);
        writeData();
    }
    public void DeleteRelationShip(Stopping init,Stopping End){
        graph.AddRelationShip(init,End,NullState);
        writeData();
    }
    public int getPosition(Stopping stopping){
        return nodes.FindFirstInstancePosition(stopping);
    }
    public void writeData(){
        double[][] matrix=graph.getMatrix();
        LinkedListTool<Stopping> tool=new LinkedListTool<>();
        ArrayList<Stopping>  nodes=tool.toJavaList(graph.getNodes());
        JsonExchange.toJsonFromObject(RelationRoute,matrix);
        JsonExchange.toJsonFromObject(NodesRoute,nodes);
    }
    public DoubleList<Stopping> getShortestRoad(Stopping init, Stopping End){
        return dijkstra.getShortestRoute(init, End);
    }
    public void addStopping(String Name){
        Stopping stopping=new Stopping(StoppingID,Name);
        graph.AddNode(stopping);
        StoppingID++;
    }
    public int getLen(){
        return graph.NodesNumber();
    }

}
