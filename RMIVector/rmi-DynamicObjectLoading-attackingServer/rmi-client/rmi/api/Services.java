package rmi.api;

import java.rmi.RemoteException;
import rmi.Message;

public interface Services extends java.rmi.Remote {
    String sendMessage(Message msg) throws RemoteException;
}