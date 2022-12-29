package rmi.api;

import java.rmi.RemoteException;

public interface Services extends java.rmi.Remote {
    Object sendMessage(String msg) throws RemoteException;
}