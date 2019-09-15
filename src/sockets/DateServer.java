package sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServer {
	public static void main(String[] args) throws IOException
	{
		ServerSocket listener = new ServerSocket(8191);
		//int i = 0 ;
		try 
		{
			while (true) 
			{
				Socket socket = listener.accept();
				//i++; //client num count
				try 
				{
					PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
					out.println(new Date().toString());
						
					//while(true);//pour bloquer la session telnet
					
				} finally 
				{
					System.out.println(".....closing");
					socket.close();
				}
			}
		}
		finally { listener.close(); }
	}
}