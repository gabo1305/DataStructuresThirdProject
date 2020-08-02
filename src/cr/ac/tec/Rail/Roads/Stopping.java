package cr.ac.tec.Rail.Roads;

import java.util.Objects;

public class Stopping implements Comparable {
    private int ID;
    private String gpsPosition;
    private String Name;
    public Stopping(){

    }
    public Stopping(int ID,String Name){
        this.ID=ID;
        this.Name=Name;
        this.gpsPosition="";
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getGpsPosition() {
        return gpsPosition;
    }

    public void setGpsPosition(String gpsPosition) {
        this.gpsPosition = gpsPosition;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stopping stopping = (Stopping) o;
        return Objects.equals(getID(), stopping.getID());
    }

    @Override
    public int compareTo(Object o) {
        if(o==this)return 0;
        if(o==null)return 1;
        if(!(o instanceof Stopping))return 1;
        Stopping stopping=(Stopping)o;
        if(this.ID>stopping.ID)return 1;
        if(this.ID<stopping.ID)return -1;
        return 0;
    }

    @Override
    public String toString() {
        return Name;
    }
}
