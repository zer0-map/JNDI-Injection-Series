package rmi.api.imp;
import java.rmi.RemoteException;
import rmi.api.Services;
import rmi.Message;

public class ServicesImpl implements Services {
    @Override
    public String sendMessage(Message msg) throws RemoteException {
        return "Received message from client" ;
    }
}
