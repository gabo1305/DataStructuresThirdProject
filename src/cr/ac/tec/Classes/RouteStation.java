package cr.ac.tec.Classes;

import cr.ac.tec.Rail.Roads.Nodes;

import java.util.ArrayList;

public class RouteStation {
    ArrayList<Nodes> nodes = new ArrayList<Nodes>();//This save the station
    ArrayList<Edges> edges = new ArrayList<Edges>();//This saved the routes
    public RouteStation(ArrayList<Nodes> Nodes,ArrayList<Edges> Edges){
        this.nodes=Nodes;
        this.edges=Edges;
    }
}
