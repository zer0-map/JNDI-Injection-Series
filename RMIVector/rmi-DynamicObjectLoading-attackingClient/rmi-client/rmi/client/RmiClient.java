//RMIClient1.java
package rmi.client;

import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi.api.Services;

public class RmiClient {

    public static void main(String[] args) throws Exception {
        String host = "localhost";
        if (args.length > 0)
            host = args[0];

        System.setProperty("java.security.policy", RmiClient.class.getClassLoader().getResource("resources/java.policy").getFile());
        RMISecurityManager securityManager = new RMISecurityManager();
        System.setSecurityManager(securityManager);

        Registry registry = LocateRegistry.getRegistry(host, 9999);
        Services services = (Services) registry.lookup("Services");
        services.sendMessage("hello");
    }
}