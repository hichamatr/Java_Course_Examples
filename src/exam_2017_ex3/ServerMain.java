package exam_2017_ex3;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * 
 * @author Hicham abo ahmad
 * Exercice 3 => { exam : 2017 }
 * ********************************
 * Classe principale pour lancer le serveur
 *******************************************/
public class ServerMain {

	public static void main(String[] args) throws RemoteException {
		
		ServeurImp servObj = new ServeurImp();
		
		Registry registry = LocateRegistry.createRegistry(1099);
		registry.rebind("chatServer", servObj);
	}

}
