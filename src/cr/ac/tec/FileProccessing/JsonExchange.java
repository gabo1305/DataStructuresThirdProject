package cr.ac.tec.FileProccessing;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

public class JsonExchange {
    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();
    //private static  Gson gson=new Gson();
    private static JsonParser parser=new JsonParser();
    public static Object getObjectFromJson(String route, Class cl){
        try {
            if (route == null) return null;
            String text = PlainText.readFile(route);
            parser.parse(text);
            Object o = gson.fromJson(text, cl);
            return o;
        }
        catch (Exception exception){
            System.out.println("Llegue a una excepcion");
            System.out.println(exception.getMessage());
            System.out.println( exception.getCause().toString());
            return null;
        }
    }
    public static void toJsonFromObject(String route, Object object){
        try {
           String text= gson.toJson(object);
            System.out.println(text);
            PlainText.writeFile(route,text);
        }
        catch (Exception e){

        }

    }
    public static String getStringFromObject(Object object){
        try {
            return gson.toJson(object);
        }
        catch (Exception e){return "";}
    }



}
