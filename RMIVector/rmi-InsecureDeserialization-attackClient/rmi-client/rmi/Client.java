package rmi;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi.api.User;

public class Client {

    public static void main(String[] args) throws Exception {
        String host = "localhost";
        if (args.length > 0)
            host = args[0];        

        Registry registry = LocateRegistry.getRegistry(host,1099);
        User user = (User) registry.lookup("user");
        user.getUser();
    }
}