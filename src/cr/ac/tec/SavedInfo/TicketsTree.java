package cr.ac.tec.SavedInfo;

import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;
import cr.ac.tec.DataStructures.Tree.BinaryTree;
import cr.ac.tec.FileProccessing.JsonExchange;
import cr.ac.tec.Rail.Accounts.User;
import cr.ac.tec.Rail.Purchase.Ticket;
import cr.ac.tec.Rail.Roads.Nodes;

public class TicketsTree extends InfoTree<Ticket> {
    private static int IDCounter;
    private static TicketsTree instance;
    private TicketsTree(){
        route="C:\\Tecnologico de Costa Rica\\Tercer Semestre\\Algoritmos y estructuras\\RailSpot\\JsonFiles\\Tickets.json";
        Tree=new BinaryTree<>();
        getData();
    }
    public static TicketsTree getInstance(){
        if(instance==null){
            synchronized (TicketsTree.class){
                if(instance==null){
                    instance=new TicketsTree();
                }
            }
        }
        return instance;
    }
    @Override
    public void getData() {
        Ticket[] tickets=(Ticket[]) JsonExchange.getObjectFromJson(route,Ticket[].class);
        Tree.append(tickets);
        IDCounter=tickets.length;
    }
    public Ticket createTicket(User user, DoubleList<Nodes> trajectory){
        if(user==null || trajectory==null)return null;
        Ticket ticket=new Ticket(user.getID(),trajectory);
        ticket.setID(IDCounter);
        attach(ticket);
        user.addTicket(ticket);
        IDCounter++;
        return ticket;
    }
}
