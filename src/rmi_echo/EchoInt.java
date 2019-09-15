package rmi_echo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EchoInt extends Remote{
	public String getMsg(String inputMsg) throws RemoteException;
}
