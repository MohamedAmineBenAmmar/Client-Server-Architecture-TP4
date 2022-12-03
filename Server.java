import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends ObjetString {
    public Server() {}
    public static void main(String []args) {
        try {
            // Instantiating the implementation class
            ObjetString obj = new ObjetString();

            // Exporting the object of implementation class
            // (here we are exporting the remote object to the stub)
            ObjectStringInterface stub = (ObjectStringInterface) UnicastRemoteObject.exportObject(obj, 0);

            // Binding the remote object (stub) in the registry
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 2002);

            registry.bind("remoteObject", stub);
            System.err.println("Server ready");



        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
} 