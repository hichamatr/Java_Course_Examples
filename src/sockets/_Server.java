package sockets;

import java.io.IOException;
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
public class _Server {

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
						//creation des flots de lecture et d'écriture ASCII
						Scanner in = new Scanner( client_sock.getInputStream()) ;
						PrintWriter out = new PrintWriter(client_sock.getOutputStream(), true) ;
						
						out.println("connection effectuer au serveur!!! ");
						
						//wait something from the client 
						String line;
						
						System.out.println("<SERVER> waiting for client input ");
						
						try {
							while ( !( line = in.nextLine() ).isEmpty())
							 System.out.println("<SERVER> from the client : " + line);
						}catch( Exception e) {
							//System.out.println(e);
						}
						
						
				}finally {
					System.out.println("closing.....");
					client_sock.close();
				}
				
	
			}
		}finally 
    	{
			listener.close();
		}
	} catch (IOException e) {}
	
 }

}
