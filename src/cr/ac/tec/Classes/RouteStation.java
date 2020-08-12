package cr.ac.tec.Classes;

import cr.ac.tec.Rail.Roads.Nodes;

import java.util.ArrayList;

/**
 * This class define the routes
 * @author Andrey Zuñiga
 */
public class RouteStation {
    ArrayList<Nodes> nodes = new ArrayList<Nodes>();//This save the station
    ArrayList<Edges> edges = new ArrayList<Edges>();//This saved the routes

    /**
     * The constructor
     * @param Nodes
     * @param Edges
     */
    public RouteStation(ArrayList<Nodes> Nodes,ArrayList<Edges> Edges){
        this.nodes=Nodes;
        this.edges=Edges;
    }
}
