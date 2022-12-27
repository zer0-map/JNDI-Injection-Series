package rmi.client;
import java.rmi.*;
import java.util.Arrays;
import rmi.api.HelloService;

public class RmiClient {
  public static void main(String[] args) {
    String host = "localhost:8888";
    if (args.length > 0)
      host = args[0];
    try {
      String names[]=Naming.list("rmi://" + host + "/helloService");
      System.out.println("I am client, it is service list: "+Arrays.asList(names));

      HelloService h = (HelloService) Naming.lookup("rmi://" + host + "/helloService");

      System.out.println("It is on client, the result from server is "+h.sayHello("John"));
    } catch (Exception ex) {
      System.out.println("error: " + ex);
    }
  }
}