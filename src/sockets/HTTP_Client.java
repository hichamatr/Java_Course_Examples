package sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HTTP_Client {

	public static void main(String[] args) {

		Socket socket ;
		String g = "GET / HTTP/1.1\n" + "Host: www.ensias.ma\n\n" ;
		try
		{
			socket = new Socket("www.ensias.ma", 80);
			OutputStream out = socket.getOutputStream();
			
			out.write(g.getBytes());

			//reading 
			InputStream in = socket.getInputStream();
			
			byte[] b = new byte[1000];
			
			//pour les données renvoyées
			int nbBytsRecus = in.read(b); //effectivement recues
			if(nbBytsRecus>0)
			{
				System.out.println(nbBytsRecus + " bits recus.");
				System.out.println("Recu: "+ new String(b,0,nbBytsRecus)); 
			}
		}catch (IOException ex )
		{ 
			System.out.println(ex);
		}



	}

}
