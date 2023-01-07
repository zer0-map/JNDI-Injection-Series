package rmi;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.Naming;
import rmi.api.User;
import rmi.api.imp.LocalUser;

public class Server {
        public static void main(String[] args) throws Exception{
        String url = "rmi://127.0.0.1:1099/user";
        User user = new LocalUser("bob",15);
        LocateRegistry.createRegistry(1099);
        Naming.bind(url,user);
        System.out.println("the rmi is running ...");
    }
}