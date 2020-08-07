package cr.ac.tec.DataStructures.Graphs;

import cr.ac.tec.DataStructures.Array.ArrayTools;
import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;
import cr.ac.tec.DataStructures.LinkedList.List.Tools.LinkedListTool;
import org.w3c.dom.Node;

import java.util.ArrayList;

public  class Graph<T> {
    private DoubleList<T> Nodes;
    private double[][] Matrix;
    private final int relationSize=2;
    private final int from=0;
    private final int to=1;
    public Graph(DoubleList<T> List){
        this.Nodes=List;
        if(List==null)List=new DoubleList<T>();
        this.Matrix=new double[Nodes.getLength()][Nodes.getLength()];
        initiateMatrix();
    }
    private void initiateMatrix(){
        for(int i=0;i<Matrix.length;i++){
            initiateArray(Matrix[i]);
        }
    }
    private void initiateArray(double[] List){
        if(List==null)return;
        for(int i=0;i<List.length;i++){
            List[i]=Integer.MAX_VALUE;
        }
    }
    public DoubleList<T> getNodes(){
        return Nodes;
    }
    public void AddRelationShip(T Node1,T Node2,int weight){
        int pos1=Nodes.FindFirstInstancePosition(Node1);
        int pos2=Nodes.FindFirstInstancePosition(Node2);
        if(!verification(pos1) || !verification(pos2))return;
        Matrix[pos1][pos2]=weight;
    }
    public double[][] getMatrix() {
        return Matrix;
    }
    public void setRelationShip(double[][] relationShip){
        if(relationShip==null)return;
        if(relationShip.length!=Nodes.getLength())return;
        this.Matrix=relationShip;
    }


    private boolean verification(int data){
        if(data<0 || data>=Matrix.length)return false;
        return true;
    }
    public void AddNode(T addNode){
        if(addNode==null)return;
        Nodes.AddTail(addNode);
        Matrix= ArrayTools.expandDoubleMatrix(Matrix);
        initiateArray(Matrix[Matrix.length-1]);
        initiateLastPosition();
    }
    public void deleteNode(T node){
        int pos= Nodes.FindFirstInstancePosition(node);
        if(pos<0)return;
        Nodes.delete(pos);
        Matrix=ArrayTools.deleteDoubleRow(Matrix,pos);
    }
    private void initiateLastPosition(){
        for(int i=0;i<Matrix.length;i++){
            Matrix[i][Matrix.length-1]=Integer.MAX_VALUE;
        }
    }
    public DoubleList<T> getRelationShips(T node){
        int pos=Nodes.FindFirstInstancePosition(node);
        if(!verification(pos))return null;
        double[] temp=Matrix[pos];
        DoubleList<T> returning=new DoubleList<T>();
        for(int i=0;i<temp.length;i++){
            if(temp[i]<Integer.MAX_VALUE) returning.AddTail(Nodes.get(i));
        }
        return returning;
    }
    public ArrayList<ArrayList<T>> getRelationShips(){
        ArrayList<ArrayList<T>> List=new ArrayList<>();
        DoubleList<T> NodesRelations;
        ArrayList<T> arrayList;
        for(int i=0;i<Nodes.getLength();i++){
            NodesRelations=getRelationShips(Nodes.get(i));
            for(int j=0;j<NodesRelations.getLength();j++){
                arrayList=new ArrayList<>();
                arrayList.add(Nodes.get(i));
                arrayList.add(NodesRelations.get(j));
                List.add(arrayList);
            }
        }
        return List;
    }
    public int NodesNumber(){
        if(Nodes==null)return 0;
        return Nodes.getLength();
    }
    public boolean inGraph(T info){
        if(Nodes==null)return false;
        return Nodes.inList(info);
    }
    public double[] getConnections(T node){
        int pos;
        pos=Nodes.FindFirstInstancePosition(node);
        if(pos<0)return null;
        return Matrix[pos];
    }
}
