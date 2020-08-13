package cr.ac.tec.SavedInfo;

import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;
import cr.ac.tec.DataStructures.Tree.BinaryTree;
import cr.ac.tec.FileProccessing.JsonExchange;
import cr.ac.tec.Rail.Accounts.User;
import cr.ac.tec.Rail.Purchase.Ticket;
import cr.ac.tec.Rail.Roads.Nodes;

/**
 *
 */
public class TicketsTree extends InfoTree<Ticket> {
    private static int IDCounter=0;
    private static TicketsTree instance;

    /**
     *
     */
    private TicketsTree(){
        route="C:\\Users\\Gabriel Solano\\Documents\\GitHub\\DataStructuresThirdProyect\\JsonFiles\\Tickets.json";
        Tree=new BinaryTree<>();
        getData();
    }

    /**
     *
     * @return
     */
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

    /**
     *
     */
    @Override
    public void getData() {
        Ticket[] tickets=(Ticket[]) JsonExchange.getObjectFromJson(route,Ticket[].class);
        if(tickets==null)return;
        Tree.append(tickets);
        IDCounter=tickets.length;
    }

    /**
     *
     * @param user
     * @param trajectory
     * @return
     */
    public Ticket createTicket(User user, DoubleList<Nodes> trajectory){
        if(user==null || trajectory==null)return null;
        Ticket ticket=new Ticket(user.getID(),trajectory);
        ticket.setID(IDCounter);
        attach(ticket);
      ///  user.addTicket(ticket);
        IDCounter++;
        return ticket;
    }
    public DoubleList<Ticket> getTickets(){
        return Tree.getListInOrder();
    }
}
