package cr.ac.tec.Rail.RequestManager;


import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;
import cr.ac.tec.Rail.Accounts.User;
import cr.ac.tec.Rail.Purchase.Ticket;
import cr.ac.tec.Rail.RailGraph;
import cr.ac.tec.Rail.Roads.Nodes;
import cr.ac.tec.Rail.TakenRoad;
import cr.ac.tec.SavedInfo.TicketsTree;
import cr.ac.tec.SavedInfo.UsersTree;

public class RequestManager {
    private static RequestManager instance;
    private RailGraph graph;
    private TakenRoad takenRoad;
    private UsersTree usersTree;
    private TicketsTree ticketsTree;
    private RequestManager(int a){
        graph=RailGraph.getInstance();
        takenRoad=TakenRoad.getInstance(a);
        usersTree=UsersTree.getInstance();
        ticketsTree=TicketsTree.getInstance();
    }
    public static RequestManager getInstance(int a){
        if(instance==null){
            synchronized (RequestManager.class){
                if(instance==null){
                    instance=new RequestManager(a);
                }
            }
        }
        return instance;
    }
    public void AddUser(String id){
        User user=new User(id);
        usersTree.attach(user);
    }
    public Ticket BuyTicket(String name, String start, String end){
        User user=new User(name);
        User myUser=getUser(user);
        Nodes startPoint=graph.getNode(start);
        Nodes endPoint=graph.getNode(end);
        if(startPoint==null || endPoint==null)return null;
        DoubleList<Nodes> route=graph.getShortestRoad(startPoint,endPoint);
        markTakenRoute(route);
        Ticket ticket=ticketsTree.createTicket(user,route);
        myUser.addTicket(ticket);
        usersTree.updateFile();
        return ticket;

    }
    public User getUser(User user){
        User returning =usersTree.getMember(user);
        if(returning==null){
            usersTree.attach(user);
            returning=user;
        }
        return returning;
    }
    private void markTakenRoute(DoubleList<Nodes> List){
        if(List==null)return;
        int a;
        int b;
        for(int i=0;i<List.getLength()-1;i++){
            a=graph.getPosition(List.get(i));
            b=graph.getPosition(List.get(i+1));
            takenRoad.setState(a,b,true);
        }
    }
    public void addNode(String Name){
        graph.addStopping(Name);
        takenRoad.expandMatrix();
    }
    public void deleteNode(String Name){
       int pos= graph.getPosition(graph.getNode(Name));
       if(pos<0 || pos>=takenRoad.getLen())return;
       if(takenRoad.verifyTo(pos))return;
       if(takenRoad.verifyFrom(pos))return;
       graph.deleteNode(Name);
       takenRoad.delete(pos);
    }
    public void deleteRelationShip(String Name1, String Name2){

    }
    public void updateGraphFileRep(){
        graph.updateGraphReference();
    }


}
