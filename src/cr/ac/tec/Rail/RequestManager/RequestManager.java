package cr.ac.tec.Rail.RequestManager;


import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;
import cr.ac.tec.Rail.Accounts.User;
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
    public void BuyTicket(User user, Nodes start, Nodes end){
        User myUser=getUser(user);
        DoubleList<Nodes> route=graph.getShortestRoad(start,end);


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
    public void updateGraphFileRep(){
        graph.updateGraphReference();
    }


}
