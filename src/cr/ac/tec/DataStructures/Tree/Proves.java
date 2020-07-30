package cr.ac.tec.DataStructures.Tree;


public class Proves {
    public static void main(String[] args) {
        SplayTree<Integer> tree=new SplayTree<>();
        tree.insertion(12);
        tree.insertion(33);
        tree.insertion(88);
        tree.insertion(65);
        tree.insertion(84);
        tree.insertion(21);
        tree.insertion(13);

        System.out.println("The root is " +tree.getRoot().getInfo());

        System.out.println("The root is " +tree.getRoot().getInfo());


    }
}
