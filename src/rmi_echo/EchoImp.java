package rmi_echo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class EchoImp extends UnicastRemoteObject implements EchoInt{

	protected EchoImp() throws RemoteException {
		super();
	}
	
	@Override
	public String getMsg(String inputMsg) throws RemoteException {
		return "Echo du message : <"+ inputMsg + ">";
	}

}
