package exam_2017_ex3;

/**
 * 
 * @author Hicham abo ahmad
 * Exercice 3 => { exam : 2017 }
 * ********************************
 * implémentation de linterface client
 ****************************************/

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Client extends UnicastRemoteObject implements ClientInterface{

	private ServerInterface service;//pour acceder au service du serveur
	private String pseudo;
	
	protected Client() throws RemoteException {
		super();
	}

	//se connecter au serveur ( compris l'ajout d'un nouveau client à la table des clients connectés au serveur )
	public void connect(String url, String pseudo){
		
		try {
			service = (ServerInterface)Naming.lookup(url) ;//"rmi://localhost:1099/chatServer"
			this.pseudo = pseudo;
			
			//add this client to the table of clients in the server
			service.addNewClient(pseudo, this);
			
		} catch (MalformedURLException e) {
		} catch (RemoteException e) {
		} catch (NotBoundException e) {
		} 

	}
	
	//se deconnecter du serveur ( justement retirer le client de la liste)
	public void disconnect(){
		try {
			service.removeClient(pseudo);
		} catch (RemoteException e)// on doit traiter l'exception puisque la methode removeClient() declenche (throws) cette exception
		{
			e.printStackTrace();
		}
	}

	//envoyer au serveur pour faire le broadcasting vers les autres clients -- cette methode va appeler la methode "sendToOthers" implementé dans le serveur 
	public void send(String msg){
		try {
			service.sendToOthers(this, msg);// on fait passer le client actuel pour l'exlure lors du broadcast (ne pas renvoyé le message a lui meme) -- see the implementation at the server side
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	//affichage local d'un message
	public void showMsg(String str) {
		System.out.println(str);	
	}

}
