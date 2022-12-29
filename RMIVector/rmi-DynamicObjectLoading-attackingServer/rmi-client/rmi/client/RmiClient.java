//RMIClient1.java
package rmi.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi.api.Services;
import rmi.remoteclass.Calc;

public class RmiClient {

    public static void main(String[] args) throws Exception {
        String host = "localhost";
        if (args.length > 0)
            host = args[0];

        System.setProperty("java.rmi.server.codebase", "http://192.168.0.96:8000/");

        Registry registry = LocateRegistry.getRegistry(host, 9999);

        Services services = (Services) registry.lookup("Services");

        Calc calc = new Calc();

        services.sendMessage(calc);
    }
}