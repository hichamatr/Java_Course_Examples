package sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class _Client {

	public static void main(String[] args) {
		
		try 
		{
			Socket sock_client = new Socket("localhost",9997) ;
			
			//ASCII input stream 
			Scanner in = new Scanner(sock_client.getInputStream());
			
			//read message from the server (accepted connection for example)
			String line = in.nextLine() ;
			
			System.out.println("<CLIENT> from the server : " + line);

			//ASCII output stream 
			PrintWriter out = new PrintWriter(sock_client.getOutputStream(),true);
			
			try 
			{
				Thread.sleep(5000);// 5 seconds before sending 
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			//send a hello world message
			out.println("hello world, here i am\n„—Õ»« »ﬂ„\n ok \n ok ahlan");
			while(true);
			//sock_client.close();
		} catch (UnknownHostException e) {
		} catch (IOException e) {}
	
		
		
		
	}

}
