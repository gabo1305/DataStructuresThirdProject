package cr.ac.tec.Rail;

import cr.ac.tec.Classes.Edges;
import cr.ac.tec.Classes.RouteStation;
import cr.ac.tec.DataStructures.ArrayList.ArrayTools;
import cr.ac.tec.DataStructures.Graphs.Graph;
import cr.ac.tec.DataStructures.Graphs.GraphsAlgorithm.Dijkstra;
import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;
import cr.ac.tec.DataStructures.LinkedList.List.Tools.LinkedListTool;
import cr.ac.tec.FileProccessing.JsonExchange;
import cr.ac.tec.Rail.Roads.Nodes;

import java.util.ArrayList;

public class RailGraph {
    private static final int from=0;
    private static final int to=1;
    private static int StoppingID;
    private final int NullState=0;
    private final String NodesRoute="C:\\Users\\Gabriel Solano\\Documents\\GitHub\\DataStructuresThirdProyect\\JsonFiles\\Nodes.json";
    private final String RelationRoute="C:\\Users\\Gabriel Solano\\Documents\\GitHub\\DataStructuresThirdProyect\\JsonFiles\\RelationNodes.json";
    private final String graphReferenceRelationShip="C:\\Users\\Gabriel Solano\\Documents\\GitHub\\DataStructuresThirdProyect\\web\\estaciones.json";
    private Dijkstra<Nodes> dijkstra;
    private Graph<Nodes> graph;
    private DoubleList<Nodes> nodes;
    private static RailGraph instance;
    private RailGraph(){
        graph=new Graph(getNodes());
        graph.setRelationShip(getRoads());
        dijkstra=new Dijkstra<>();
        dijkstra.setGraph(graph);
        nodes=graph.getNodes();
        updateGraphReference();
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
    private DoubleList<Nodes> getNodes(){
        Nodes[] nodes =(Nodes[])JsonExchange.getObjectFromJson(NodesRoute, Nodes[].class);
        ArrayTools<Nodes> tools=new ArrayTools<>();
        return tools.getDoubleList(nodes);
    }
    private double[][] getRoads(){
        return (double[][])JsonExchange.getObjectFromJson(RelationRoute,double[][].class);
    }
    public void AddRelationShip(Nodes Init, Nodes End, int weight){
        graph.AddRelationShip(Init,End,weight);
        writeData();
    }
    public void DeleteRelationShip(Nodes init, Nodes End){
        graph.AddRelationShip(init,End,NullState);
        writeData();
    }
    public int getPosition(Nodes nodes){
        return this.nodes.FindFirstInstancePosition(nodes);
    }
    public void writeData(){
        double[][] matrix=graph.getMatrix();
        LinkedListTool<Nodes> tool=new LinkedListTool<>();
        ArrayList<Nodes>  nodes=tool.toJavaList(graph.getNodes());
        JsonExchange.toJsonFromObject(RelationRoute,matrix);
        JsonExchange.toJsonFromObject(NodesRoute,nodes);
        updateGraphReference();
    }
    public DoubleList<Nodes> getShortestRoad(Nodes init, Nodes End){
        return dijkstra.getShortestRoute(init, End);
    }
    public void addStopping(String Name){
        Nodes nodes =new Nodes(StoppingID,Name);
        graph.AddNode(nodes);
        StoppingID++;
        writeData();
    }
    public int getLen(){
        return graph.NodesNumber();
    }
    public void updateGraphReference(){
        LinkedListTool<Nodes> tool=new LinkedListTool<>();
        ArrayList<Nodes> Nodes=tool.toJavaList(graph.getNodes());
        ArrayList<ArrayList<Nodes>> RelationList=graph.getRelationShips();
        ArrayList<Edges> edges=new ArrayList<>();
        for (int i=0;i<RelationList.size();i++){
            edges.add(new Edges(RelationList.get(i),Integer.toString(i)));
        }
        RouteStation routeStation=new RouteStation(Nodes,edges);
        JsonExchange.toJsonFromObject(graphReferenceRelationShip,routeStation);

    }
    public void deleteNode(String id){
        Nodes node=getNode(id);
        if(node==null)return;
        graph.deleteNode(node);
        writeData();

    }
    public Nodes getNode(String ID){
        DoubleList<Nodes> TheNodes=graph.getNodes();
        for(int i=0;i<TheNodes.getLength();i++){
            if(ID.equalsIgnoreCase(TheNodes.get(i).toString()))return TheNodes.get(i);
        }
        return null;
    }

}
