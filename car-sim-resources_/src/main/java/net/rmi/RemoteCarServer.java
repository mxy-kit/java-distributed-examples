package net.rmi;

import net.command.SerializableCommand;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteCarServer extends Remote{ // Remote是java自带的，他自己就是Register的基础
    <T> T executeCommand(SerializableCommand command) throws RemoteException; // 这个类中的方法就是服务中有的方法
}