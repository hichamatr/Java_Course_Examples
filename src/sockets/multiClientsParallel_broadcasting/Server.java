package sockets.multiClientsParallel_broadcasting;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author Abo ahmed
 * 
 * desc : the server handle multiple clients concurrently.. send them a message
 * 		  then receive a feed-back
 *
 */

public class Server {

	public static void main(String[] args) {
		
		try {
			ServerSocket listener = new ServerSocket(9899);
			
			while ( true )
			{
				System.out.println("incomming request!!"); //lors d'1 new connection to server this printing shows only that the server is ready for another one for this we observe it before any treatments during the execution of the program
				
				Socket sock_client = listener.accept() ; // new connection
				
				Runnable r = new ClientHandler(sock_client);
				Thread th = new Thread(r);
				
				th.start();
				
			}
		} catch (IOException e) 
		{}
		
	}
}
