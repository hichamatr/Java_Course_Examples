package sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class _Client_bin {

	public static void main(String[] args) {
		
		try 
		{
			Socket sock_client = new Socket("localhost",9997) ;
			
			//binary input stream 
			InputStream in = sock_client.getInputStream();
			
			byte[] myBytes = new byte[1000]; 
			
			//read message from the server (accepted connection for example) ==> read it in myBytes array
			int nbBitsRecus = in.read(myBytes); //effectivement recues
			
			if ( nbBitsRecus > 0 )
				System.out.println("<CLIENT> from the server : " + new String(myBytes,0,nbBitsRecus)); /// => new String(myBytes,0,nbBitsRecus);

			//binary output stream 
			OutputStream out = sock_client.getOutputStream();
			
			try 
			{
				Thread.sleep(10000);
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
			//send a hello world message
			String str =  "hello world, here i am\n„—Õ»« »ﬂ„\n" ;
			out.write(str.getBytes());
			
			
		} catch (UnknownHostException e) {
		} catch (IOException e) {}
	
		
		
		
	}

}
