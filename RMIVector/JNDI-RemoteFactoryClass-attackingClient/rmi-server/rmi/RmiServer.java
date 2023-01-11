package rmi;

import com.sun.jndi.rmi.registry.ReferenceWrapper;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import javax.naming.NamingException;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.naming.Reference;

public class RmiServer {
    public static void main(String[] args) throws RemoteException, NamingException, AlreadyBoundException {
        try {

            Registry reg;
            try {      
                reg = LocateRegistry.createRegistry(9999);
                System.out.println("java RMI registry created. port on 9999...");
            } catch (Exception e) {
                System.out.println("Using existing registry");
                reg = LocateRegistry.getRegistry();
            } 

            Reference Services = new Reference("Calc", "remoteclass.Calc", "http://192.168.0.95:8000/");
            ReferenceWrapper ServicesWrapper = new ReferenceWrapper(Services);           
            reg.bind("Services", ServicesWrapper);

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
