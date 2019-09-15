package sockets.chat_app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 * 
 * @author 
 *
 *	Cette classe aussi suit le serveur!
 */

public class Chat extends Thread
{
	private int numClient;
	private Socket sock_client; // socket de base
	private ArrayList<Socket> listClientsConnectee; // les autres sockets
	
	public Chat(int numClient, Socket sock_client, ArrayList<Socket> listClientsConnectee)
	{
		this.numClient = numClient;
		this.sock_client = sock_client;
		this.listClientsConnectee = listClientsConnectee;
	}
	
	public void run() {
		
		System.out.println("Client <"+ numClient + "> connected...");
		InputStream is;
		try {
			
			// recuperation du flux de lecture avec le client "sock_client"
			is = sock_client.getInputStream();
			InputStreamReader ipsr=new InputStreamReader(is);
			BufferedReader reader=new BufferedReader(ipsr);
			
			// recup du flux d'écriture
			OutputStream os = sock_client.getOutputStream();
			PrintWriter writer= new PrintWriter(os,true);
			
			//le serveur envoi au client ce message
			writer.println("\nVous etes connecte en tant que Client "+numClient+" !\n");
			
			String msg;
			
			while(true)
			{
				//n'envoyer qu'aprés avoir lire.. à partir du client "numClient"
				msg=reader.readLine();
				
				if(msg!=null)
				{
					for(Socket socket : listClientsConnectee)
					{  // on va envoyer à tous les autres clients "sauf" sock_client! ( déja "sock_client" est inclut dans la liste des clients donc on doit l'exclure puisque c'est lui qui veut envoyer au autre dans ce thread)
					   // 
						if(socket!=sock_client)
						{
							//recupération du flux d'ecriture (avec les autres clients) 
							OutputStream aos = socket.getOutputStream();
							PrintWriter other_sock_writer= new PrintWriter(aos,true);
							
							//affichage sophistiqué
							other_sock_writer.println("\nClient "+  numClient +" : "+ msg);
						}
					}
				}	
				
			 }
			
		} catch (IOException e) {}
		
	}
}
