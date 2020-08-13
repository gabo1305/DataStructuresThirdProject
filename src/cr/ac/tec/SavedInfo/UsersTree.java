package cr.ac.tec.SavedInfo;

import cr.ac.tec.DataStructures.Tree.BinaryTree;
import cr.ac.tec.FileProccessing.JsonExchange;
import cr.ac.tec.Rail.Accounts.User;

/**
 *
 */
public class UsersTree extends InfoTree<User> {
    private static UsersTree instance;

    /**
     *
     */
    private UsersTree(){
        Tree=new BinaryTree<>();
        this.route="C:\\Users\\Gabriel Solano\\Documents\\GitHub\\DataStructuresThirdProyect\\JsonFiles\\Users.json";
        getData();
    }

    /**
     *
     * @return
     */
    public static UsersTree getInstance(){
        if(instance==null){
            synchronized (UsersTree.class){
                if(instance==null){
                    instance=new UsersTree();
                }
                System.out.println();
            }
        }
        return instance;
    }

    /**
     *
     */
    @Override
    public void getData() {
        User[] users=(User[]) JsonExchange.getObjectFromJson(route,User[].class);
        Tree.append(users);
    }
}
