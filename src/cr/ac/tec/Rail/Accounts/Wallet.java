package cr.ac.tec.Rail.Accounts;


import cr.ac.tec.Rail.Purchase.Ticket;

import java.util.ArrayList;

/*
 It used to save the id of the tickets that the client has purchased
 */
public class Wallet {
    private ArrayList<Integer> tickets;
    public Wallet(){
        tickets=new ArrayList<>();
    }

    public void AddTicket(Ticket ticket){
        if(ticket==null)return;
        tickets.add(ticket.getID());
    }

    public ArrayList<Integer> getTickets(){
        return tickets;
    }

}
