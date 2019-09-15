package rmi_echo;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		EchoInt service = (EchoInt)Naming.lookup("rmi://localhost:1099/echoMsg") ;
		System.out.println(service.getMsg("Hello RMI ^^"));
	}
}
