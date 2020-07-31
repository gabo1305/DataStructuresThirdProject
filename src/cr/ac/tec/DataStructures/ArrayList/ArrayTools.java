package cr.ac.tec.DataStructures.ArrayList;

import java.util.ArrayList;

public class ArrayTools<T> {
    public void append(ArrayList <T> Source,ArrayList<T> appending ){
        if(Source==null || appending==null)return;
        for(int i=0;i<appending.size();i++){
            Source.add(appending.get(i));
            //xd
        }

    }
}
