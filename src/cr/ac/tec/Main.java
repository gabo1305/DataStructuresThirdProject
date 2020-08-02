package cr.ac.tec;

import cr.ac.tec.DataStructures.ArrayList.ArrayTools;
import cr.ac.tec.DataStructures.Graphs.Graph;
import cr.ac.tec.DataStructures.Graphs.GraphsAlgorithm.Dijkstra;
import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;
import cr.ac.tec.DataStructures.LinkedList.List.Tools.LinkedListTool;
import cr.ac.tec.FileProccessing.JsonExchange;
import cr.ac.tec.Rail.Roads.Stopping;

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
        DoubleList<Stopping> List=new DoubleList<>();
        List.AddTail(new Stopping(0,"Heredia"));
        List.AddTail(new Stopping(1,"Santo Domingo"));
        List.AddTail(new Stopping(2,"Tibas"));
        List.AddTail(new Stopping(3,"Moravia"));
        List.AddTail(new Stopping(4,"San Jose"));
        List.AddTail(new Stopping(5,"San Pedro"));
        List.AddTail(new Stopping(6,"Guadalupe"));
        List.AddTail(new Stopping(7,"Sabanilla"));
        List.AddTail(new Stopping(8,"Curridabat"));
        List.AddTail(new Stopping(9,"Zapote"));
        List.AddTail(new Stopping(10,"Tres Rios"));
        List.AddTail(new Stopping(11,"Cartago"));
        List.AddTail(new Stopping(12,"Paraiso"));
        double [][] matrix=new double[13][13];
        matrix[0][1]=1;
        matrix[1][0]=1;
        matrix[1][2]=1;
        matrix[2][1]=1;
        matrix[2][4]=1;
        matrix[3][2]=1;
        matrix[3][6]=1;
        matrix[4][2]=1;
        matrix[4][5]=1;
        matrix[4][9]=1;
        matrix[5][4]=1;
        matrix[5][6]=1;
        matrix[5][8]=1;
        matrix[6][3]=1;
        matrix[6][5]=1;
        matrix[7][4]=1;
        matrix[7][5]=1;
        matrix[8][5]=1;
        matrix[8][10]=1;
        matrix[9][4]=1;
        matrix[9][10]=1;
        matrix[10][9]=1;
        matrix[10][11]=1;
        matrix[11][10]=1;
        matrix[11][12]=1;
        matrix[12][11]=1;
        //JsonExchange.toJsonFromObject("C:\\Tecnologico de Costa Rica\\Tercer Semestre\\Algoritmos y estructuras\\RailSpot\\JsonFiles\\RelationNodes.json",matrix);

        LinkedListTool<Stopping> tool=new LinkedListTool<>();
        ArrayList<Stopping> the=tool.toJavaList(List);
        //JsonExchange.toJsonFromObject("C:\\Tecnologico de Costa Rica\\Tercer Semestre\\Algoritmos y estructuras\\RailSpot\\JsonFiles\\Nodes.json",the);
        boolean[][] taken=new boolean[13][13];
        JsonExchange.toJsonFromObject("C:\\Tecnologico de Costa Rica\\Tercer Semestre\\Algoritmos y estructuras\\RailSpot\\JsonFiles\\TakenRoad.json",taken);
    }
}
