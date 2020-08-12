package cr.ac.tec.Rail;
import cr.ac.tec.FileProccessing.JsonExchange;
import java.util.ArrayList;
public class RouteRegister {
    private ArrayList<ArrayList<ArrayList<Integer>>> RoutesRegister;
    private final String route="C:\\Users\\Gabriel Solano\\Documents\\GitHub\\DataStructuresThirdProyect\\JsonFiles\\ReservationRegister.json";
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
        System.out.println(this.RoutesRegister.size());
        System.out.println("llamado a verificacion");
        if(!verification(a,b))return false;
        System.out.println("Print del check despues del false");
        return RoutesRegister.get(a).get(b).isEmpty();
    }
    public ArrayList<Integer> getIDs(int a, int b){
        if(!verification(a,b))return null;
        return RoutesRegister.get(a).get(b);
    }
    public void AddData(int data,int a, int b){
        if(!verification(a,b))return;
        System.out.println("llegue al mundo del mago oscuro");
        RoutesRegister.get(a).get(b).add(data);
        System.out.println(RoutesRegister.get(a).get(b).get(0));
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
        System.out.println("esto es a: "+a);
        System.out.println("esto es b: "+b);
        if(!verification(a))return false;
        return true;
    }
    private boolean verification(int data){
        if(data<0 || data>=RoutesRegister.size())return false;
        return true;
    }
    public ArrayList<Integer> getFromNode(int pos){
        if(!verification(pos))return null;
        ArrayList<Integer> List=new ArrayList<>();
        getFrom(List,pos);
        getTo(List,pos);
        return List;
    }
    private void getFrom(ArrayList<Integer> List,int pos){
        if(List==null)return;
        ArrayList<ArrayList<Integer>> source=RoutesRegister.get(pos);
        ArrayList<Integer> temp;
        for(int i=0;i<source.size();i++){
            temp=source.get(i);
            for(int j=0;j<temp.size();j++){
                System.out.println(temp.get(j));
                if(!List.contains(temp.get(j))) List.add(temp.get(j));
            }
        }
    }
    private void getTo(ArrayList<Integer> List,int pos){
        if(List==null)return;
        if(!verification(pos))return;
        ArrayList<Integer> temp;
        for(int i=0;i<RoutesRegister.size();i++){
            temp=RoutesRegister.get(i).get(pos);
            for(int j=0;j<temp.size();j++){
                if(!List.contains(temp.get(j)))List.add(temp.get(j));
            }
        }
    }

    public void getData(){
        ArrayList<ArrayList<ArrayList<Integer >>> theList= new ArrayList<ArrayList<ArrayList<Integer>>>();
        //theList=(ArrayList<ArrayList<ArrayList<Integer>>>)JsonExchange.getObjectFromJson(route,theList.getClass());
        int[][][] Data=(int[][][]) JsonExchange.getObjectFromJson(route,int[][][].class);
        appendArray(theList,Data);
        if(theList!=null)this.RoutesRegister=theList;
    }
    public void writeData(){

      //  System.out.println(JsonExchange.toJsonFromObject(route,this.RoutesRegister));
        System.out.println("-----------------------------------------------------------------");
        System.out.println(JsonExchange.getStringFromObject(this.RoutesRegister));
        JsonExchange.toJsonFromObject(route,this.RoutesRegister);
    }
    private void appendArray(ArrayList<ArrayList<ArrayList<Integer>>>List ,int[][][] array){
        if(array==null)return;
        if(List==null)return;
        for(int i=0;i<array.length;i++){
            List.add(new ArrayList<>());
            for(int j=0;j<array[i].length;j++){
                List.get(i).add(new ArrayList<>());
                for(int k=0;k<array[i][j].length;k++){
                    List.get(i).get(j).add(array[i][j][k]);
                }
            }
        }
    }

}
