package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * *********************************************************************************************************
 * @author Abo ahmed
 * 
 * desc : we have two problems : 
 * 								1) "blocking" (data exchange) we must wait the other side ( writing ) before reading (synchronisation)
 * 								2) the clients are handled one by one
 * 
 ************************************************************************************************************
 */
public class _Server_Buffered {

 public static void main(String[] args) 
 {
	try {
		//création du socket serveur:
		ServerSocket listener = new ServerSocket(9997);
		
    try {
			while ( true )
			{
				System.out.println("\nwaiting for a new connection.....\n");	
				//attente de connexion d'un client ( les connexion are queued in the port )
					Socket client_sock = listener.accept();
					try 
					{
						//creation des flots de lecture et d'écriture
						InputStream in = client_sock.getInputStream() ;
						InputStreamReader isr = new InputStreamReader(in);
						BufferedReader lecteur = new BufferedReader(isr) ;						
						
						OutputStream out = client_sock.getOutputStream();
						
						out.write("connection effectuer au serveur!!!\n".getBytes());
						
						//wait something from the client 						
						System.out.println("<SERVER> waiting for client input ");
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
								
								//read again
								line = lecteur.readLine() ;
							}
							System.out.println("after while loop");
						
						/* presque la meme chose mais autrement
						 * try {
							while ( !( line = lecteur.readLine() ).isEmpty() )
							{
								System.out.println("<SERVER> from the client : " + line);
								Thread.sleep(1000);
							}
							
						}catch( Exception e) {
							System.out.println(e);
						}*/
						
						
				}finally {
					System.out.println("closing.....");
					client_sock.close();
				}
				
	
			}
		}finally 
    	{
			listener.close();
		}
	} catch (IOException e) {
		System.out.println("what is this e = " + e);
	}
	
 }

}
