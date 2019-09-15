package sockets.chat_app;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class ServeurChat{

	public static void main(String[] args)
	{
		ArrayList<Socket> listClientsConnectee = new ArrayList<Socket>(); // liste de tous les clients qui ont accedés au serveur
		int numClient = 0 ; // nb de clients actually connected to the server
		ServerSocket serv_sock; // gestionnaire de sockets
		
		try {
			serv_sock = new ServerSocket(9000);
			
			while(true)
			{
				Socket sock_client = serv_sock.accept();
				listClientsConnectee.add(sock_client);
				numClient++;
				new Chat(numClient, sock_client, listClientsConnectee).start();
				
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();

		}

	}
}
