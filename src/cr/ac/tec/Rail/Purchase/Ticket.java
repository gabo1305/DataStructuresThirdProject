package cr.ac.tec.Rail.Purchase;

import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;
import cr.ac.tec.Rail.Roads.Nodes;

import java.util.ArrayList;
import java.util.Date;

public class Ticket implements Comparable{
    private int ID;
    private String[] trajectory;
    private Date date;
    private String UserID;
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }



    public Ticket(String UserID, Nodes... trajectory){
        setTrajectory(trajectory);
        this.UserID=UserID;
        this.date=new Date();
    }
    public Ticket(String UserID, DoubleList<Nodes> doubleList){
        this.UserID=UserID;
        this.date=new Date();
        setTrajectory(doubleList);

    }
    public Ticket(){}
    public void setTrajectory(DoubleList<Nodes> List){
        if(List==null)return;
        this.trajectory=new String[List.getLength()];
        for(int i=0;i<List.getLength();i++){
            trajectory[i]=List.get(i).toString();
        }
    }

    public String[] getTrajectory() {
        return trajectory;
    }

    public void setTrajectory(Nodes... trajectory) {
        if(trajectory==null)return;
        this.trajectory = new String[trajectory.length];
        for(int i=0;i<trajectory.length;i++){
            this.trajectory[i]=trajectory[i].toString();
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }
    public void setTrajectory(ArrayList<String> Trajectory){
        if(trajectory==null)return;
        this.trajectory=new String[Trajectory.size()];
        for(int i=0;i<Trajectory.size();i++){
            trajectory[i]=Trajectory.get(i);
        }
    }
    public void setTrajectory(String[] trajectory){
        this.trajectory=trajectory;
    }


    @Override
    public int compareTo(Object o) {
        if(o==null)return 1;
        if(! (o instanceof Ticket))return 1;
        Ticket ticket=(Ticket) o;
        return Integer.compare(this.ID,ticket.ID);
    }

}
