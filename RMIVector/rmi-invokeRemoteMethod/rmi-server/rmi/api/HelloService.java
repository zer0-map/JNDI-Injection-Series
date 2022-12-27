package rmi.api;
import java.rmi.*;

public interface HelloService extends Remote{
  public String sayHello(String message) throws RemoteException;
}