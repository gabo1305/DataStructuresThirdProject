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
    private final int NullState=Integer.MAX_VALUE;
    private final String NodesRoute="C:\\Users\\migue\\DataStructuresThirdProject\\JsonFiles\\Nodes.json";
    private final String RelationRoute="C:\\Users\\migue\\DataStructuresThirdProject\\JsonFiles\\RelationNodes.json";
    private final String graphReferenceRelationShip="C:\\Users\\migue\\DataStructuresThirdProject\\web\\estaciones.json";
    private Dijkstra<Nodes> dijkstra;
    private Graph<Nodes> graph;
    private DoubleList<Nodes> nodes;
    private static RailGraph instance;
    private static double size=5;
    private RailGraph(){
        graph=new Graph(getNodes());
        graph.setRelationShip(getRoads());
        dijkstra=new Dijkstra<>();
        dijkstra.setGraph(graph);
        nodes=graph.getNodes();
        updateGraphReference();
        StoppingID=graph.NodesNumber();
       if (!nodes.isEmpty())size=nodes.get(0).getSize();
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
    public void addStopping(String Name,double XPos,double YPos){
        Nodes nodes =new Nodes(StoppingID,Name);
        nodes.setX(XPos);
        nodes.setY(YPos);
        nodes.setSize(size);
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
        double[][] values=graph.getMatrix();
        ArrayList<Edges> edges=new ArrayList<>();
        Edges reference;
        ArrayList<Nodes> TempList;
        double price;
        for (int i=0;i<RelationList.size();i++){
            TempList=RelationList.get(i);
            reference=new Edges(TempList,Integer.toString(i));
            price=values[Integer.parseInt(TempList.get(from).getID())][Integer.parseInt(TempList.get(to).getID())];
            reference.setLabel(Double.toString(price));
            edges.add(reference);

        }
        RouteStation routeStation=new RouteStation(Nodes,edges);
        JsonExchange.toJsonFromObject(graphReferenceRelationShip,routeStation);

    }
    public void deleteNode(String id){
        Nodes node=getNode(id);
        if(node==null)return;
        graph.deleteNode(node);
        StoppingID--;
        writeData();

    }
    public Nodes getNode(String ID){
        DoubleList<Nodes> TheNodes=graph.getNodes();
        for(int i=0;i<TheNodes.getLength();i++){
            if(ID.equalsIgnoreCase(TheNodes.get(i).toString()))return TheNodes.get(i);
        }
        return null;
    }
    public boolean isThereAName(String Name){
        if(Name==null)return false;
        DoubleList<Nodes> List=graph.getNodes();
        for(int i=0;i<List.getLength();i++){
            if(Name.equalsIgnoreCase(List.get(i).getName()))return true;
        }
        return false;
    }
    public double getPrice(Nodes node1,Nodes node2){
        if(node1==null || node2==null)return NullState;
        return dijkstra.getPrice(node1,node2);
    }
    public static void setSize(double data){
        if(data<=0)return;
        if(size==0)size=data;
    }
    public boolean isThereARoute(Nodes node1,Nodes node2){
        double price=dijkstra.getPrice(node1,node2);
        if(price==Integer.MAX_VALUE)return false;
        return true;
    }
    public boolean isThereAnEdge(Nodes node1,Nodes node2){
        DoubleList<Nodes> List=graph.getRelationShips(node1);
        if(List.inList(node2))return true;
        return false;
    }
    public double getEdgePrice(String Node1,String Node2){
        if(Node1==null)return NullState;
        if(Node2==null)return NullState;
        Nodes From=getNode(Node1);
        Nodes To=getNode(Node2);
        if(From==null)return NullState;
        if(To==null)return NullState;
        double[] List=graph.getConnections(From);
        return List[graph.getNodes().FindFirstInstancePosition(To)];
    }


}
