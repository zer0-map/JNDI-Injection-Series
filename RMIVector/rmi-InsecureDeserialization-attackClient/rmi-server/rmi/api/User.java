package rmi.api;
import java.rmi.RemoteException;

public interface User extends java.rmi.Remote {
    public Object getUser() throws RemoteException;
}