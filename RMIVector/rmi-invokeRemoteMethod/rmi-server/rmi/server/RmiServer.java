package rmi.server;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import rmi.api.imp.HelloServiceImpl;


public class RmiServer {
  public static void main(String[] args) {
    try {
      System.out.println("RMI Server Starts...");
      LocateRegistry.createRegistry(8888);

      HelloServiceImpl hImpl = new HelloServiceImpl();
      System.out.println("Bind the hImpl to helloService");
      Naming.bind("rmi://localhost:8888/helloService", hImpl);

      System.out.println("Waiting to be invoked by Client...");
      Thread.sleep(10000000);
      System.out.println("RMI Server Stops");
    } catch (Exception e) {
      System.out.println("error: " + e);
    }
  }
}