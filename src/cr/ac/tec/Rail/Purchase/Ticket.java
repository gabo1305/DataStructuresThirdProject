package cr.ac.tec.Rail.Purchase;

import cr.ac.tec.Rail.Roads.Stopping;

import java.util.Date;

public class Ticket implements Comparable{
    private int ID;
    private String[] trajectory;
    private Date date;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    private String UserID;

    public Ticket(String UserID,Stopping... trajectory){
        setTrajectory(trajectory);
        this.UserID=UserID;
        this.date=new Date();
    }

    public String[] getTrajectory() {
        return trajectory;
    }

    public void setTrajectory(Stopping... trajectory) {
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

    @Override
    public int compareTo(Object o) {
        if(o==null)return 1;
        if(! (o instanceof Ticket))return 1;
        Ticket ticket=(Ticket) o;
        return Integer.compare(this.ID,ticket.ID);
    }
}
