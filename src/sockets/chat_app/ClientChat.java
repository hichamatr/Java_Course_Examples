package sockets.chat_app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class ClientChat {

	private static Socket sock_client;

	public static void main(String[] args) {			
		
		try {
		//creation du socket client
		sock_client = new Socket("localhost",9000);
		
		
		//recuperation du flux de lecture avec le serveur
		InputStream is=sock_client.getInputStream();
		InputStreamReader ipsr=new InputStreamReader(is);
		final BufferedReader reader =new BufferedReader(ipsr);
		
		// recuperation du flux d'ecriture avec le serveur
		OutputStream os= sock_client.getOutputStream();
		final PrintWriter writer = new PrintWriter(os,true);
		
		
		Thread reception = new Thread( new Runnable(){
			String msg;

			public void run() 
			{
				while ( true ) 
				{
					try 
					{
						msg=reader.readLine();
						if(msg!=null) System.out.println(msg);
					}
					catch (IOException e) 
						//e.printStackTrace();
					{
					}
				}
			}
		});
		
		Thread emission= new Thread(){


			private Scanner sc;

			public void run() {
				while(true){
					// pour lire à partir de l'entré standard
					sc = new Scanner(System.in);
					String str = sc.nextLine() ;
					
					//envoyer ce qui est été lu
					writer.println(str); 
				}
			}
		};
		
		emission.start();
		reception.start();
		}catch ( UnknownHostException uhe)
		{
			uhe.printStackTrace();
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		//System.out.println("<client> end main");
}//main
}
