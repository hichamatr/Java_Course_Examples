package exam_2017_ex3;
/**
 * 
 @author Hicham abo ahmad
 * Exercice 3 => { exam : 2017 }
 * ********************************
 * implementation de l'interface serveur
 *****************************************/
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map.Entry;

public class ServeurImp extends UnicastRemoteObject implements ServerInterface{

	HashMap<String, ClientInterface> clientsTable ; //pseudo , client
	
	protected ServeurImp() throws RemoteException {
		super();
		clientsTable = new HashMap<>();
	}

	//Ajouter un nouveau client à la liste des client connectés au serveur
	public void addNewClient(String pseudo ,ClientInterface client) throws RemoteException {
		clientsTable.put(pseudo, client);
	}

	//enlever un client via son pseudo 
	public void removeClient(String pseudo) throws RemoteException {
		clientsTable.remove(pseudo);
		
	}
	//le client envoyant un message va demander cette methode au part du serveur.. le serveur lui meme à travers
	//... cette methode va boucler sur l'ensemble des clients qui possède pour appeler la methode d'affichage dans ces terminaux
	@Override
	public void sendToOthers(ClientInterface client, String msg) throws RemoteException {
		
		/**1st way of doing it*/
		for (Entry<String, ClientInterface> entry : clientsTable.entrySet()) 
		{
			//à chaque itteration obtenir la valeur (objet client) -- j'ai mis aussi en commentaire comment extraire la clé.. meme c'est pas util ici
			//String pseudo =  entry.getKey()  ; 
			ClientInterface cls = entry.getValue() ;
			
			if ( !cls.equals(client) )
			{
				//affichage sous la forme : <source du msg> : <msg>
				cls.showMsg("<*> : " + msg);//appel chez le client rappelez vous : le serveur n'a pas de methode qui s'appel 
												  //showMsg c'est le client qui a cette methode, et puisqu'on a rien retourner au serveur 
												  //le message sera affiché dans le coté client seulement
			}
		}
		/** 2nd way of doing it ...
		 * 
		  Collection<ClientInterface> values = clientsTable.values();		  
	      Iterator<ClientInterface> iterator = values.iterator();
	      
	      //consulter tous les clients du serveur
	      while (iterator.hasNext()) {
	        ClientInterface cls =  iterator.next() ; 
	        if ( !cls.equals(client) )
	        {
	        	cls.showMsg("<*> : " + msg);//appel chez le client rappelez vous : le serveur n'a pas de methode qui s'appel 
	        								//showMsg c'est le client qui a cette methode, et puisqu'on a rien retourner au serveur 
	        								//le message sera affiché dans le coté client seulement
	        }
	      }
		*/
	}

}
