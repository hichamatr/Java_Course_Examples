package rmi_echo;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RegServ {
	public static void main(String args[]) throws Exception
	{
		EchoInt objEcho = new EchoImp() ;
		Registry register = LocateRegistry.createRegistry(1099);
		register.rebind("echoMsg",objEcho) ;
	}

}
