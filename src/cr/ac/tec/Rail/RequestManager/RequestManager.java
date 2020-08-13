package cr.ac.tec.Rail.RequestManager;
import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;
import cr.ac.tec.Rail.Accounts.User;
import cr.ac.tec.Rail.Purchase.Ticket;
import cr.ac.tec.Rail.RailGraph;
import cr.ac.tec.Rail.Roads.Nodes;
import cr.ac.tec.Rail.RouteRegister;
import cr.ac.tec.SavedInfo.TicketsTree;
import cr.ac.tec.SavedInfo.UsersTree;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class RequestManager {
    private static RequestManager instance;
    private RailGraph graph;
    private UsersTree usersTree;
    private TicketsTree ticketsTree;
    private RouteRegister register;
    private RequestManager(){
        graph=RailGraph.getInstance();
        usersTree=UsersTree.getInstance();
        ticketsTree=TicketsTree.getInstance();
        register=new RouteRegister();

    }
    public static RequestManager getInstance(){
        if(instance==null){
            synchronized (RequestManager.class){
                if(instance==null){
                    instance=new RequestManager();
                }
            }
        }
        return instance;
    }
    public void AddUser(String id){
        User user=new User(id);
        usersTree.attach(user);
    }
    public Ticket BuyTicket(String name, String start, String end, Date date){
        User user=new User(name);
        User myUser=getUser(user);
        Nodes startPoint=graph.getNode(start);
        Nodes endPoint=graph.getNode(end);
        if(startPoint==null || endPoint==null)return null;
        DoubleList<Nodes> route=graph.getShortestRoad(startPoint,endPoint);
        if(route==null || route.isEmpty())return null;
        Ticket ticket=ticketsTree.createTicket(user,route);
        ticket.setPrice(graph.getPrice(startPoint,endPoint));
        if(date!=null)ticket.setDate(date);
        ticketsTree.updateFile();
       markTakenRoute(route,ticket.getID());
        myUser.addTicket(ticket);
        usersTree.updateFile();
        Ticket another=ticketFromAnother(ticket);
        getLabel(another);
        return another;

    }
    public ArrayList<Ticket> getTicket(String name,String start,String end,int TicketsNumber,Date date){
        ArrayList<Ticket> List=new ArrayList<>();
        Ticket ref;
        for(int i=0;i<TicketsNumber;i++){
            ref=BuyTicket(name,start,end,date);
            if(ref!=null)List.add(ref);
        }
        return List;
    }
    public User getUser(User user){
        User returning =usersTree.getMember(user);
        if(returning==null){
            usersTree.attach(user);
            returning=user;
        }
        return returning;
    }
    private void markTakenRoute(DoubleList<Nodes> List,int id){
        if(List==null)return;
        int a;
        int b;
        for(int i=0;i<List.getLength()-1;i++){
            a=graph.getPosition(List.get(i));
            b=graph.getPosition(List.get(i+1));
            register.AddData(id,a,b);
        }
    }
    public boolean addNode(String Name,String XPos,String YPos){
        if(graph.getNode(Name)!=null)return false;
        graph.addStopping(Name,Double.parseDouble(XPos),Double.parseDouble(YPos));
        register.expand();
        updateGraphFileRep();
        return true;
    }
    public boolean addRelationShip(String Name1,String Name2,int weight){
        Nodes node1=graph.getNode(Name1);
        Nodes node2=graph.getNode(Name2);
        if(node1==null || node2==null)return false;
        if(graph.isThereAnEdge(node1,node2))return false;
        graph.AddRelationShip(node1,node2,weight);
        updateGraphFileRep();
        return true;
    }
    public boolean deleteNode(String Name){
       int pos= graph.getPosition(graph.getNode(Name));
       if(!register.deleteNode(pos))return false;
       graph.deleteNode(Name);
       updateGraphFileRep();
       return true;
    }
    public boolean deleteRelationShip(String Name1, String Name2){
        Nodes node1=graph.getNode(Name1);
        Nodes node2=graph.getNode(Name2);
        System.out.println("Esto es node1: "+node1);
        System.out.println("Esto es node2: "+node2);

        if(node1==null || node2==null)return false;
        if(!register.check(graph.getPosition(node1),graph.getPosition(node2)))return false;
        graph.DeleteRelationShip(node1,node2);
        updateGraphFileRep();
        return true;
    }
    public ArrayList<Ticket> getTicketsByUser(String UserName){
        User user=usersTree.getMember(new User(UserName));
        if(user==null)return null;
        ArrayList<Integer> ID=user.getWallet().getTickets();
        return getTicketsFromID(ID);

    }
    public ArrayList<Ticket> getTicketByNode(int position){
       if(position<0 || position>graph.getLen())return null;
        ArrayList<Integer> ID=register.getFromNode(position);
        return getTicketsFromID(ID);
    }


    public ArrayList<Ticket> getTicketsFromID(ArrayList<Integer> ID){
        if(ID==null)return null;
        ArrayList<Ticket> tickets=new ArrayList<>();
        Ticket reference;
        for(int i=0;i<ID.size();i++){
            reference=new Ticket(null);
            reference.setID(ID.get(i));
            reference=ticketsTree.getMember(reference);
            if(reference!=null)tickets.add(reference);
        }

        return translateTicket(tickets);
    }
    public ArrayList<Ticket> getTicketsFromDate(String Date){
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(Date);
            DoubleList<Ticket> Tickets=ticketsTree.getTickets();
            Calendar calendar=Calendar.getInstance();
            calendar.setTime(date);
            return findDate(calendar,Tickets);
        }
        catch (Exception e){}
            return null;
    }
    private ArrayList<Ticket> findDate(Calendar calendar,DoubleList<Ticket> List){
        if(calendar==null)return null;
        if(List==null)return null;
        ArrayList<Ticket> returning=new ArrayList<>();
        Calendar ref=Calendar.getInstance();
        for(int i=0;i<List.getLength();i++){
            ref.setTime(List.get(i).getDate());
            if( calendar.get(Calendar.DAY_OF_YEAR) == ref.get(Calendar.DAY_OF_YEAR) && calendar.get(Calendar.YEAR) == ref.get(Calendar.YEAR)){
                returning.add(List.get(i));
            }
        }
        return translateTicket(returning);
    }
    public ArrayList<Ticket> translateTicket(ArrayList<Ticket> tickets){
        if(tickets==null)return null;
        Ticket ref;
        ArrayList<Ticket> List=new ArrayList<>();
        for(int i=0;i<tickets.size();i++){
            ref=ticketFromAnother(tickets.get(i));
            getLabel(ref);
            List.add(ref);
        }
        return List;
    }
    public Ticket Ticket(String ID){
        Ticket ticket=new Ticket(null);
        ticket.setID(Integer.parseInt(ID));
        return ticketsTree.getMember(ticket);
    }
    public double getPrice(String Name1,String Name2){
        Nodes node1=graph.getNode(Name1);
        Nodes node2=graph.getNode(Name2);
        return graph.getPrice(node1,node2);
    }
    public Ticket ticketFromAnother(Ticket ticket){
        if(ticket==null)return null;
        Ticket newTicket=new Ticket();
        newTicket.setDate(ticket.getDate());
        newTicket.setID(ticket.getID());
        newTicket.setPrice(ticket.getPrice());
        newTicket.setUserID(ticket.getUserID());
        newTicket.setTrajectory(ticket.getTrajectory());
        return newTicket;
    }
    public void getLabel(Ticket ticket){
        if(ticket==null)return;
        String[] route=ticket.getTrajectory();
        ArrayList<String> List=new ArrayList<>();
        for(int i=0;i<route.length;i++){
            List.add(graph.getNode(route[i]).getName());
        }
        ticket.setTrajectory(List);

    }

    public void updateGraphFileRep(){
        graph.updateGraphReference();
    }


}
