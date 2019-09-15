package exam_2018.exam_2018_ex_1_v2;

/**
 * still the same as V.1
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur_Jouer {

	public static void main(String[] args)
	{

		ServerSocket sock_serv ; 
		Socket client_sock ;
		
		try {
			//1.1
			 sock_serv = new ServerSocket(12000) ;
			 
			try { // traitement serveur deja ouvert => peut avoir un problem donc il faut le traiter with finally
			
				//1.2
				 client_sock = sock_serv.accept() ;
				 System.out.println("new client connexion.");
		
				 try {
						//1.3
						InputStream in = client_sock.getInputStream() ;
						BufferedReader lecteur = new BufferedReader(new InputStreamReader(in)) ;						
						
						String line = "" ;
						while ( !( line = lecteur.readLine() ).isEmpty() )
						 System.out.println("<SERVER> reads from the client : " + line);
					 }
					 finally
					 {
						 client_sock.close();
					 }
		
			/*
				  try {
					while ( ( line = lecteur.readLine() ) != null )
					System.out.println("<SERVER> reads from the client : " + line);
				  }catch( Exception e) {
					System.out.println(e);
			}*/
			}finally {
				sock_serv.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
