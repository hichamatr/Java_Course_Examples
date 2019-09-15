package exam_2018.ex_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * **************************************************************************************
 * @author hicham Abo ahmad
 * -this version of the solution fits the requirments of the exercice.
 * -the second version we'll add the try-finally blocks to treats closing operations..
 * and also the exception handling issues (not required in the exercice).
 * 
 * **************************************************************************************
 **/
public class Serveur_multi extends Serveur_Jouet{
	
	ServerSocket server ; 
	
	public Serveur_multi(String port) {
		try {
			//conversion en un entier => peut declencher une exception si la chaine "port" à convertir ne contient pas un entier
			int portNum = Integer.parseInt(port) ;
			
			// si nous n'avons pas de probleme au niveau conversion on crée notre gestionnaire sur ce port
			server = new ServerSocket(portNum);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		Serveur_multi sm = new Serveur_multi("12200");
		sm.run();
		

	}
	
	public  void run()
	{
		//nos sockets client seront traiter une aprés autre via ce reference.
		Socket sock ;
		
		try {
			
			while (true)
			{
				System.out.println(" écouter le serveur_socket ");
				
				//attente d'une nouvelle connection
				sock = server.accept();
				
				//notre traitemnt
				serviceCLient(sock);
				
				sock.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void serviceCLient(Socket sock) throws IOException
	{
		
		System.out.println("a new client is connected to the server...");
		
		//recuperer le flux d'entré
		InputStream in = sock.getInputStream() ;
		BufferedReader lecteur = new BufferedReader(new InputStreamReader(in)) ;						
		
		String line = "" ;
		line = lecteur.readLine() ;
		
		
			while ( line != null && !line.isEmpty() ) // null lorsqu'on sort du session => si on applique isEmpty sur une string null => exception
			{										  // c'est pour cela le test null est avant isEmpty, si null : on ne check pas isEmpty puisque c'est AND
				//print the actual line read from the client
				System.out.println("<SERVER> reads from the client : " + line);
				
				//check if the line contains the "FINISH" sequence
				if ( line.contains("FINISH") )
				{
					System.out.println("i read FINISH");
					break; // pour sortir de la boucle et ensuit sortir de la méthode
				}
				
				/**
				 * ****************************************************************************************************************************************************
				 * * le problem ici si on force l'arret du client telnet on va appliquer cette lecture dans ce niveau
				 * * sur le lecteur qui depend li meme aussi du socket, et puisqu'il n'y a pas de session avec le client (à cause de cette arret forcé) donc on va avoir 
				 * * une erreur (plus précisement une exception de type "SocketException").. c'est pour cela l'arret conventionel entre 
				 * * le serveur et le client en utilisant la sequence "FINISH" assure que le client a bien envoyé son message complétement et donc on ferme sort "proprement" du programme..
				 * * si on n'implement pas comme ça on ne peut pas savoir..
				 * ****************************************************************************************************************************************************
				 * * donc si j'ai finish je vais empecher le serveur de lire à partir de l'extremite */
				
				//read again
				line = lecteur.readLine() ;
			}
			
		/// le closing du socket se fait ailleure
	}

}
