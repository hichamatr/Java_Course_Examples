package exam_2018.exam_2018_ex_1_v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * **************************************************************************************
 * @author hicham Abo ahmad
 * the second version adds the try-finally blocks to treats closing operations..
 * and also deals with exception issues (not required in the exercice).
 * 
 * **************************************************************************************
 * TODO : améliorations : 1.ignore the case when reading FINISH sequence.
 * 				  		  2.FINISH should be a work ( not included in a word)
 */
public class Serveur_multi extends Serveur_Jouer{
	
	private static ServerSocket server ; 
	
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
		try 
		{
			try
			{
				sm.run(); // throws IOException as we se
			}finally {
				server.close();
			}
		}
		catch (Exception e) // on peut détailler ici en traitant les deux exceptions UnknownHostException et IOException.. en deux blocks catch
		{
			e.printStackTrace();
		}
		

	}
	
	public  void run() throws IOException
	{
		//nos sockets client seront traiter une aprés autre via ce reference.
		Socket sock ;
					
			while (true)
			{
				System.out.println(" écouter le serveur_socket ");
				
				//attente d'une nouvelle connection
				sock = server.accept();
				
				try {
					//notre traitemnt
					serviceCLient(sock);
				}finally { 
					sock.close();// no problem to call close here be cause we throws the IOException to be handled outside
				}
			}

	}
	
	public void serviceCLient(Socket sock) throws IOException /*on va traiter cette exception à l'exterieur ie: dans la méthode appelante*/ 
	{
		
		System.out.println("a new client is connected to the server...");
		
		//recuperer le flux d'entré
		InputStream in = sock.getInputStream() ;
		BufferedReader lecteur = new BufferedReader(new InputStreamReader(in)) ;						
		
		String line = "" ;
		while ( !( line = lecteur.readLine() ).isEmpty() )
		{
			//print the actual line read from the client
			System.out.println("<SERVER> reads from the client : " + line);
			
			//check if the line contains the "FINISH" sequence
			if ( line.contains("FINISH") )
			{
				System.out.println("i read FINISH");
				break; // pour sortir de la boucle et ensuit sortir de la méthode
			}
		}

	}

}
