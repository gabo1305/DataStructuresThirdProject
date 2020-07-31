package cr.ac.tec.DataStructures.Graphs.GraphsAlgorithm;

import cr.ac.tec.DataStructures.Graphs.Graph;
import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;
import cr.ac.tec.DataStructures.LinkedList.List.List;
import cr.ac.tec.DataStructures.Stack.Stack;


public class Dijkstra<T> {
    private Graph<T> graph;
    private double[] values;
    private int[] predecessor;
    private T Starting;
    public void setGraph(Graph<T> graph){
        this.graph=graph;
    }
    public void getRoutes(T node){
        if(graph==null)return;
        if(node.equals(Starting))return;
        Starting=node;
        if(!graph.inGraph(node))return;
        int[] predecessor=new int[graph.NodesNumber()];
        initiatePredecessor(predecessor);
        double[] value=new double[graph.NodesNumber()];
        initiateValues(value);
        double[][] relationShips=graph.getMatrix();
        int pos=graph.getNodes().FindFirstInstancePosition(node);
        DoubleList<Integer> visited=new DoubleList<Integer>();
        value[pos]=0;
        while(visited.getLength()<value.length){
            pos=findMin(value,visited);
            analyze(pos,value,relationShips[pos],predecessor,visited);
        }
        this.values=value;
        this.predecessor=predecessor;
    }
    private void initiateValues(double[] values){
        if(values==null)return;
        for(int i=0;i<values.length;i++){
            values[i]=Integer.MAX_VALUE;
        }
    }
    private void initiatePredecessor(int[] predecessor){
        if(predecessor==null)return;
        for(int i=0;i<predecessor.length;i++){
            predecessor[i]=Integer.MAX_VALUE;
        }
    }
    private void analyze(int node,double[] values,double[] relationShips,int[] predecessor,DoubleList<Integer> visited){
        for(int i=0;i<relationShips.length;i++){
            if(relationShips[i]>0){
                if(values[node]+relationShips[i]<values[i]){
                    values[i]=values[node]+relationShips[i];
                    predecessor[i]=node;
                }
            }
        }
        visited.AddTail(node);
    }
    private int findMin(double[] array,DoubleList<Integer> ExcludedPosition){
        if(array==null)return -1;
        if(array.length<=0)return -1;
        int min=0;
        for(int i=0;i<array.length;i++){
            if(ExcludedPosition.inList(min))min=i;
            else if(array[i]<array[min] && !ExcludedPosition.inList(i))min=i;
        }
        return min;
    }
    public DoubleList<T> getShortestRoute(T start, T end){
        if(!graph.inGraph(end) || !graph.inGraph(start)){
            predecessor=null;
            values=null;
            return null;
        }
        getRoutes(start);
        int initPos=graph.getNodes().FindFirstInstancePosition(start);
        int finalPos=graph.getNodes().FindFirstInstancePosition(end);
        return getWay(initPos,finalPos);


    }
    public double getPrice(T start,T end){
        double value=Integer.MAX_VALUE;
        if(graph.inGraph(start) && graph.inGraph(end)){
            getShortestRoute(start,end);
            value= values[graph.getNodes().FindFirstInstancePosition(end)];
        }
        return value;
    }
    private Stack<Integer> findWay(int Start, int End){
        Stack<Integer>  stack=new Stack<Integer>();
        int reference=End;
        if(predecessor[reference]==Integer.MAX_VALUE)return stack;
        while(reference!=Start){
            stack.push(reference);
            reference=predecessor[reference];
        }
        stack.push(Start);
        return stack;
    }
    private DoubleList<T> getWay(int Start,int End){
        Stack<Integer> order=findWay(Start,End);
        DoubleList<T> nodes=graph.getNodes();
        DoubleList<T> road=new DoubleList<T>();
        while(!order.isEmpty()){
            road.AddTail(nodes.get(order.pop()));
        }
        return road;
    }





}
