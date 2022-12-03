import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    private Client() {}
    public static void main(String[] args) {
        try {
            // Init the scanner object
            Scanner scanner = new Scanner(System.in);

            // Communicate with the user
            System.out.println("Type your base string: ");
            String baseStr = scanner.nextLine();

            System.out.println("Type the character that you want to find within the base string (" + baseStr + ")");
            char c = scanner.next().charAt(0);

            // Getting the registry
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 2002);

            // Looking up the registry for the remote object
            ObjectStringInterface stub = (ObjectStringInterface) registry.lookup("remoteObject");

            // Calling the remote method using the obtained object
            int result = stub.NBOccurence(baseStr, c);
            System.out.println("Input: base string = " + baseStr + " Char to find: " + c);
            System.out.println("Output: " + result);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}