package cr.ac.tec.Rail.Accounts;

import cr.ac.tec.Rail.Purchase.Ticket;

import java.util.Objects;

public class User implements Comparable {
    private String ID;  //identification card
    private Wallet wallet;

    public User(String ID){
        this.ID=ID;
        wallet=new Wallet();
    }

    public Wallet getWallet() {
        return wallet;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
    public void addTicket(Ticket ticket){
        wallet.AddTicket(ticket);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o==null)return false;
        if(!(o instanceof User))return false;
        User user=(User)o;
        return this.ID.equalsIgnoreCase(user.ID);
    }


    @Override
    public int hashCode() {
        return Objects.hash(getID(), getWallet());
    }

    @Override
    public int compareTo(Object o) {
        if(o==null)return 1;
        if(o==this)return 0;
        if(!(o instanceof User))return 1;
        User user=(User)o;
        return ID.compareTo(user.ID);
    }


}
