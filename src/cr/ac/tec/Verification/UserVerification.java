package cr.ac.tec.Verification;

/**
 *
 */
public class UserVerification {
    private static final int cedDigits=9;

    /**
     *
     * @param ID
     * @return
     */
    public static boolean ced(String ID){
        if(ID==null)return false;
        if(ID.length()!=cedDigits)return false;
        try {
            Integer.parseInt(ID);
        }
        catch (Exception e){return false;}
        return true;

    }
}
