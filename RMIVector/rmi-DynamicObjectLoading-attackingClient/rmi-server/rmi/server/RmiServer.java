package rmi.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import rmi.api.imp.ServicesImpl;
import rmi.api.Services;


public class RmiServer {
    public static void main(String[] args) {
        try {

            ServicesImpl obj = new ServicesImpl();
            Services services = (Services) UnicastRemoteObject.exportObject(obj, 0);
            System.setProperty("java.rmi.server.codebase", "http://192.168.0.95:8000/");

            Registry reg;
            try {      
                reg = LocateRegistry.createRegistry(9999);
                System.out.println("java RMI registry created. port on 9999...");
            } catch (Exception e) {
                System.out.println("Using existing registry");
                reg = LocateRegistry.getRegistry();
            }            
            reg.bind("Services", services);

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
