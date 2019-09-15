package sockets.multiClientsParallel_broadcasting;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
/********************************************************************************
 * NOTES :
 *  		=> why locking? and why all these section ?(synchronized) (shared + relative treatments)
 *  		=> why not with "this" but "lock"? 
 *  
 *****************************************************************************/
/**
 * ***********************************************************************************************
 * @author abo ahmad ******************************************************************************
 * *************************************************************************************************
 * Desc : the client print the server message then send a feed-back <HIS NAME>*<STATUS(ok, ...)>*****
 * *************************************************************************************************
 *************************************************************************************************
 */
public class Client {

	 static int num = 0 ;
	 final static String lock = "Abo"; 
	
	public static void main(String[] args) {
		new Thread( new Runnable() {
			
			@Override
			public void run() {
				new Client().client() ;
				
			}
		}).start();
		
		new Thread( new Runnable() {
			
			@Override
			public void run() {
				new Client().client() ;
				
			}
		}).start();
		
		new Thread( new Runnable() {
			
			@Override
			public void run() {
				new Client().client() ;
				
			}
		}).start();
	}
	
	public void client()
	{

		
		try {
			//server connection
			Socket sock_client = new Socket("localhost",9899) ;
			synchronized(lock) {
			try 
			{
				// in|out Streams 
				Scanner in = new Scanner ( sock_client.getInputStream()) ;
				PrintWriter out = new PrintWriter(sock_client.getOutputStream() , true ) ;
				
				String line = in.nextLine();
				
				num++;
				
				
				System.out.println("<CLIENT> n°" + num + " : ");
				
					int i = 1 ;
					while ( !line.contains("FINISH"))
					{
						try 
						{
							while( line != null && !line.contains("###"))
							{
								System.out.println(line);
								//System.out.println("\ti : " + i );
								out.println("<CLIENT> : " + num + " ok! <packet> : " + i++ ); //send to server a validation msg
								line = in.nextLine();
							}
							
							if ( line.contains("###"))
							///to send the rest of the mesg ie the terminating sequence
							{
								System.out.println(line);
								out.println(line);
								line = in.nextLine(); //passer à la ligne suivante
							}
							
						}
						catch ( Exception e)
						{
							System.out.println(e);	
						}
					}
					
					///to send the rest of the mesg ie the terminating sequence
					System.out.println(line);
					
					//send END flag to the server ( invert server that i finished");
					out.println("END");
				
			}finally 
			{
				System.out.println("closing " + "<CLIENT>" + num);
				sock_client.close();
			}
		}
		}
		
		catch (UnknownHostException e) 
		{e.printStackTrace();} 
		catch (IOException e) 
		{e.printStackTrace();}
	}

}
