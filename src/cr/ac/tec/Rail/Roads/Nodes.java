package cr.ac.tec.Rail.Roads;

import java.util.Objects;

public class Nodes implements Comparable {
    private String id;
    private String label;
    private double x;
    private double y;
    private double size;
    public Nodes(){

    }
    public Nodes(int ID, String Name){
        this.id=Integer.toString(ID);
        this.label=Name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }



    public String getID() {
        return id;
    }

    public void setID(int ID) {
        this.id = Integer.toString(ID);
    }


    public String getName() {
        return label;
    }

    public void setName(String name) {label= name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nodes nodes = (Nodes) o;
        return Objects.equals(getID(), nodes.getID());
    }

    @Override
    public int compareTo(Object o) {
        if(o==this)return 0;
        if(o==null)return 1;
        if(!(o instanceof Nodes))return 1;
        Nodes nodes =(Nodes)o;
        return id.compareTo(nodes.id);
    }

    @Override
    public String toString() {
        return id;
    }
}
