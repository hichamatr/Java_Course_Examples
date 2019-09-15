package exam_2016.ex_3;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientTest {

public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		Compte service = (Compte)Naming.lookup("rmi://localhost/compteObj") ;
		System.out.println(service.getSolde());
	}

}
