package cr.ac.tec.Classes;

import cr.ac.tec.Rail.Roads.Nodes;

import java.util.ArrayList;
/**
 * @author Andrey Zuñiga
 * This class defines the relationships
 */
public class Edges {
    private static final int from=0;
    private static final int to=1;
    private static final int TheSize=2;
    private String id;
    private String source;
    private String target;
    private String label;
    private double size=20;
    private final String type= "arrow";

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }



    /**
     * The constructor
     * @param id
     * @param source
     * @param target
     *
     */
    public Edges(String id,String source,String target){
        this.id=id;
        this.source=source;
        this.target=target;
    }

    /**
     * The constructor
     * @param nodes
     * @param id
     */
    public Edges(ArrayList<Nodes> nodes, String id){
        this.id=id;
        if(nodes==null || nodes.size()!=TheSize)return;
        source=nodes.get(from).getID();
        target=nodes.get(to).getID();
    }
    // Getters
    public String getId() {
        return id;
    }

    public String getSource() {
        return source;
    }

    public String getTarget() {
        return target;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
