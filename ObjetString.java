import java.rmi.RemoteException;

public class ObjetString implements ObjectStringInterface{

    // Implementing the interface method
    public int NBOccurence(String str, char c){
        if(str.length() == 0){
            return 0;
        } else {
            if(str.charAt(0) == c){
                return 1 + NBOccurence(str.substring(1, str.length()), c);
            } else {
                return NBOccurence(str.substring(1, str.length()), c);
            }

        }
    }
}
