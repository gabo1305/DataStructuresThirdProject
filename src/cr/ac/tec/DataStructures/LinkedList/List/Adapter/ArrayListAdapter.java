package cr.ac.tec.DataStructures.LinkedList.List.Adapter;

import cr.ac.tec.DataStructures.LinkedList.List.DoubleList;

import java.util.ArrayList;

/**
 *
 * @param <T>
 */
public class ArrayListAdapter<T> extends DoubleList<T> {
    private ArrayList<T> arrayList;
    public ArrayListAdapter(ArrayList arrayList){
        this.arrayList=arrayList;
        this.length=arrayList.size();
    }

    /**
     *
     * @param position the position
     * @return
     */
    @Override
    public T get(int position) {
        if(!verification())return null;
        return arrayList.get(position);
    }

    /**
     *
     * @param Newinfo the info that'll be stored in the node
     */
    @Override
    public void AddTail(T Newinfo) {
        if(!verification())return;
        arrayList.add(Newinfo);
        length++;

    }

    /**
     *
     * @param NewInfo the info that will be stored in the node
     */
    @Override
    public void AddHead(T NewInfo) {
        if(!verification())return;
        arrayList.add(0,NewInfo);
        length++;
    }

    /**
     *
     * @param position the position to be deleted
     */
    @Override
    public void delete(int position) {
        if(!verification())return;
        if(position>= arrayList.size())return;
        arrayList.remove(position);
    }

    /**
     *
     * @return
     */

    private boolean verification(){
        if(arrayList==null ||  arrayList.size()<=0)return false;
        return true;
    }
}
