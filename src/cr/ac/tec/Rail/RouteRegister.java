package cr.ac.tec.Rail;


import cr.ac.tec.FileProccessing.JsonExchange;

import java.util.ArrayList;

public class RouteRegister {
    private ArrayList<ArrayList<ArrayList<Integer>>> RoutesRegister;
    private final String route="C:\\Users\\migue\\DataStructuresThirdProyect\\JsonFiles\\ReservationRegister.json";
    public RouteRegister(int data){
        ArrayList<ArrayList<ArrayList<Integer>>> List=new ArrayList<>();
        if(data<0)return;
        initiate(List,data);
        this.RoutesRegister=List;
        getData();
    }
    public RouteRegister(){
        this(0);
    }
    private void initiate(ArrayList<ArrayList<ArrayList<Integer>>> List,int data){
        ArrayList<ArrayList<Integer >> vector;
        for(int i=0;i<data;i++){
            vector=new ArrayList<>();
            for(int j=0;j<data;j++){
                vector.add(new ArrayList());
            }
            List.add(vector);
        }
    }
    public boolean check(int a, int b){
        if(!verification(a,b))return false;
        return RoutesRegister.get(a).get(b).isEmpty();
    }
    public ArrayList<Integer> getIDs(int a, int b){
        if(!verification(a,b))return null;
        return RoutesRegister.get(a).get(b);
    }
    public void AddData(int data,int a, int b){
        System.out.println("_______________________________________________________________");
        System.out.println("data: "+data);
        System.out.println("a: "+a);
        System.out.println("b: "+a);
        if(!verification(a,b))return;
        System.out.println("Adding "+data);
        RoutesRegister.get(a).get(b).add(data);
        writeData();
    }
    public void deleteData(int data,int a, int b){
        if(!verification(a,b))return;
        RoutesRegister.get(a).get(b).remove(data);
        writeData();
    }
    public void expand(){
        AddRow();
        AddColumn();
        writeData();
    }
    private void AddColumn(){
        for(int i=0;i<RoutesRegister.size();i++){
            RoutesRegister.get(i).add(new ArrayList<>());
        }
    }
    private void AddRow(){
        ArrayList<ArrayList<Integer>> List=new ArrayList<>();
        for(int i=0;i<RoutesRegister.size();i++){
            List.add(new ArrayList<>());
        }
        RoutesRegister.add(List);
    }
    private boolean verifyFrom(int pos){
        if(!verification(pos))return false;
        for(int i=0;i<RoutesRegister.size();i++){
            if(!RoutesRegister.get(pos).get(i).isEmpty())return false;
        }
        return true;
    }
    private boolean verifyTo(int pos){
        if(!verification(pos))return false;
        for(int i=0;i<RoutesRegister.size();i++){
            if(!RoutesRegister.get(i).get(pos).isEmpty())return false;
        }
        return true;

    }
    public boolean deleteNode(int pos){
        if(!verifyFrom(pos))return false;
        if(!verifyTo(pos))return false;
        RoutesRegister.remove(pos);
        for(int i=0;i<RoutesRegister.size();i++){
            RoutesRegister.get(i).remove(pos);
        }
        writeData();
        return true;
    }
    private boolean verification(int a,int b){
        if(!verification(b))return false;
        if(!verification(a))return false;
        return true;
    }
    private boolean verification(int data){
        if(data<0 || data>=RoutesRegister.size())return false;
        return true;
    }

    public void getData(){
        ArrayList<ArrayList<ArrayList<Integer >>> theList= new ArrayList<>();
        theList=(ArrayList<ArrayList<ArrayList<Integer>>>)JsonExchange.getObjectFromJson(route,theList.getClass());
        if(theList!=null)this.RoutesRegister=theList;
    }
    public void writeData(){
        JsonExchange.toJsonFromObject(route,this.RoutesRegister);
    }

}
