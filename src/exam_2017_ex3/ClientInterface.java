package exam_2017_ex3;
/**
 * 
 * @author Hicham abo ahmad
 * Exercice 3 => { exam : 2017 }
 * ********************************
 * Définition de l'interface coté client
 *******************************************/
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInterface extends Remote{
	
	//se connecter au serveur ( compris l'ajout d'un nouveau client à la table des clients connectés au serveur )
	public void connect(String url , String pseudo)throws RemoteException;
	
	//envoyer au serveur pour faire le broadcasting vers les autres clients -- cette methode va appeler la methode "sendToOthers" implementé dans le serveur 
	public void send(String str)throws RemoteException;
	
	//se deconnecter du serveur ( justement retirer le client de la liste) -- see the implementation
	public void disconnect()throws RemoteException;
	
	// sera appelée par le serveur! pour afficher un message envoyer par un autre client "msg" localement dans le client.
	public void showMsg(String msg) throws RemoteException;
}
