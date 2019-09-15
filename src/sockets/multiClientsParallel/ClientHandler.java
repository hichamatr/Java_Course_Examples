package sockets.multiClientsParallel;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable{

	Socket sock ;
	int i  ; //count msg
	
	public ClientHandler(Socket sock) {
		this.sock = sock ;
		i = 0 ;
	}
	
	@Override
	public void run() {
		
		try {
			 try {
				Scanner in = new Scanner ( sock.getInputStream());
				PrintWriter out = new PrintWriter(sock.getOutputStream(),true);
				
					out.println("(*) MSG : I am the server... Hello!!\n how are you \ni am hicham\n ### ");
					
					String line = in.nextLine();
					System.out.println("<SERVER>:");
					try 
					{
						int i = 1 ;
						while( line != null /* !line.contains("no") */&& !line.contains("###"))
						{
							if (!line.trim().equals(""))
							{
								System.out.println("\t"+ line);
								System.out.println("\t"+ "i : " + i++ );
							}
							
							line = in.nextLine();
						}
							
					}
					catch ( Exception e)
					{
						//System.out.println(e);
					}
					
			 }finally {
				 sock.close();
			 }
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
