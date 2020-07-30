package cr.ac.tec.DataStructures.Tree;

public class SimpleBinaryTreeWayMarker extends BinaryTreeWayMarker {
    @Override
    public void addTrace(int data) {
        if(!verification(data))return;
        Stack.push(data);

    }
}
