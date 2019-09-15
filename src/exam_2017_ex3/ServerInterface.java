package exam_2017_ex3;
/**
 * 
 * @author Hicham abo ahmad
 * Exercice 3 => { exam : 2017 }
 * ********************************
 * definition de l'interface du coté serveur
 *******************************************/
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote{
	
	//je connait le client à travers l'interface; ajouter à la liste des clients connectés un nouveau client
	public void addNewClient(String pseudo ,ClientInterface client) throws RemoteException;//ClientInterface doit etre connu pour le serveur (on l'import) dans ce cas on est dans le meme package => pas de problem
	
	//remove a client from the server
	public void removeClient(String pseudo) throws RemoteException;
		
	//envoyer le message msg du "client" vers tous les clients inscrits dans le serveur
	public void sendToOthers(ClientInterface client , String msg) throws RemoteException;
	

}
