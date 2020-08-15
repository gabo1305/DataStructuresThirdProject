package cr.ac.tec;

import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;
import cr.ac.tec.DataStructures.LinkedList.List.Tools.LinkedListTool;
import cr.ac.tec.FileProccessing.JsonExchange;
import cr.ac.tec.Rail.RequestManager.RequestManager;
import cr.ac.tec.Rail.Roads.Nodes;
import cr.ac.tec.Rail.RouteRegister;

import java.util.ArrayList;

public class Main {
    private static final String A="A";
    private static final String B="B";
    private static final String C="C";
    private static final String D="D";
    private static final String E="E";
    private static final String F="F";
    private static final String G="G";
    public static void main(String[] args) {
        DoubleList<Nodes> List=new DoubleList<>();
        List.AddTail(new Nodes(0,"Heredia"));
        List.AddTail(new Nodes(1,"Santo Domingo"));
        List.AddTail(new Nodes(2,"Tibas"));
        List.AddTail(new Nodes(3,"Moravia"));
        List.AddTail(new Nodes(4,"San Jose"));
        List.AddTail(new Nodes(5,"San Pedro"));
        List.AddTail(new Nodes(6,"Guadalupe"));
        List.AddTail(new Nodes(7,"Sabanilla"));
        List.AddTail(new Nodes(8,"Curridabat"));
        List.AddTail(new Nodes(9,"Zapote"));
        List.AddTail(new Nodes(10,"Tres Rios"));
        List.AddTail(new Nodes(11,"Cartago"));
        List.AddTail(new Nodes(12,"Paraiso"));
        double [][] matrix=new double[13][13];
        matrix[0][1]=9.06;
        matrix[1][0]=9.06;
        matrix[1][2]=4.18;
        matrix[2][1]=4.18;
        matrix[2][4]=4.01;
        matrix[3][2]=9.11;
        matrix[3][6]=8.43;
        matrix[4][2]=4.01;
        matrix[4][5]=4.35;
        matrix[4][9]=3.07;
        matrix[5][4]=4.35;
        matrix[5][6]=1.86;
        matrix[5][8]=2.23;
        matrix[6][3]=8.43;
        matrix[6][5]=1.86;
        matrix[7][4]=6.74;
        matrix[7][5]=2.71;
        matrix[8][5]=2.20;
        matrix[8][10]=5.58;
        matrix[9][4]=3.07;
        matrix[9][10]=7.99;
        matrix[10][7]=6.39;
        matrix[10][8]=5.58;
        matrix[10][9]=7.99;
        matrix[10][11]=9.21;
        matrix[11][10]=9.21;
        matrix[11][12]=6.10;
        matrix[12][11]=6.10;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                if(matrix[i][j]==0)matrix[i][j]=Integer.MAX_VALUE;
                else matrix[i][j]=25*matrix[i][j];
            }
        }
        JsonExchange.toJsonFromObject("C:\\Tecnologico de Costa Rica\\Tercer Semestre\\Algoritmos y estructuras\\RailSpot\\JsonFiles\\RelationNodes.json",matrix);
        RequestManager requestManager = RequestManager.getInstance();
        //requestManager.updateGraphFileRep();
        LinkedListTool<Nodes> tool=new LinkedListTool<>();
        ArrayList<Nodes> the=tool.toJavaList(List);
        //JsonExchange.toJsonFromObject("C:\\Tecnologico de Costa Rica\\Tercer Semestre\\Algoritmos y estructuras\\RailSpot\\JsonFiles\\Nodes.json",the);
        boolean[][] taken=new boolean[13][13];
        //JsonExchange.toJsonFromObject("C:\\Tecnologico de Costa Rica\\Tercer Semestre\\Algoritmos y estructuras\\RailSpot\\JsonFiles\\TakenRoad.json",taken);
      RouteRegister register=new RouteRegister(16);
       // register.expand();
       register.writeData();
    }
}
