package rmi.api.imp;
import java.io.Serializable;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import rmi.api.HelloService;

public class HelloServiceImpl extends  UnicastRemoteObject  implements HelloService{

    private static final long serialVersionUID = 1L;
    public HelloServiceImpl()  throws RemoteException {
      super();
    }

    public String sayHello(String message)  throws RemoteException {
      System.out.println("It is from serve, the message received from the client is " + message);
      return message;
    }
}