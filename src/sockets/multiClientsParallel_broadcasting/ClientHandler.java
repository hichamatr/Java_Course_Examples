package sockets.multiClientsParallel_broadcasting;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable{

	Socket sock ;
	int i , j=0 ; //count msg
	
	public ClientHandler(Socket sock) {
		this.sock = sock ;
		i = 0 ;
	}
	
	@Override
	public void run() {
		
		try {
				Scanner in = new Scanner ( sock.getInputStream());
				PrintWriter out = new PrintWriter(sock.getOutputStream(),true);
				
				String line ;
				while( j < 4 )
				{
					out.println(++j +"> (*) MSG : I am the server... Hello!!\n how are you \ni am XY \n ### ");
					
					try {
					  Thread.sleep(5000);
					} catch (InterruptedException e) 
					{}
					
					
					line = in.nextLine();// bloquer jusqu'a avoir des données sur le buffer
					System.out.println("<SERVER>:");
					try 
					{
						int i = 1 ;
						while( line != null && !line.contains("###"))
						{
							System.out.println("\t"+ line);
							System.out.println("\t"+ "i : " + i++ );
							
							line = in.nextLine();
							
						}
						
						System.out.println("=> j = "+ j);
					}
					catch ( Exception e)
					{
						e.printStackTrace();
					}
					
				}
				
				//finished Message
				out.println("FINISH");
				
				System.out.println("++++ from client : "+in.nextLine());
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch(Exception e)
		{
			
		}

		try {
			sock.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
