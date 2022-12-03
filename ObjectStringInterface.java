import java.rmi.Remote;
import java.rmi.RemoteException;

// Creating Remote interface for our application
public interface ObjectStringInterface extends Remote {
    public int NBOccurence(String str, char c) throws RemoteException;
}