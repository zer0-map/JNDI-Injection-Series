package rmi.api.imp;
import rmi.remoteclass.Calc;
import java.rmi.RemoteException;
import rmi.api.Services;

public class ServicesImpl implements Services {
    @Override
    public Calc sendMessage(String msg) throws RemoteException {
        return new Calc();
    }
}
