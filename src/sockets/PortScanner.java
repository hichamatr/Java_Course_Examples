package sockets;

import java.net.*; import java.io.*;

public class PortScanner {
	public static void main(String[] args) 
	{
		String host = "localo"; //localhost
		try {
			
			InetAddress adr = InetAddress.getByName(host);
			
			System.out.println(adr);
			
			for (int i = 1; i < 1024; i++) 
			{
				try {
					Socket laSocket = new Socket(adr, i);
					System.out.println("Il y a un serveur sur le port " + i + " de " + host);
				}
				catch (IOException ex) { // ne doit pas y avoir de serveur sur ce port
					System.out.println("no server at "+i);
				}
			} // end for
		} // end try
		catch (UnknownHostException e) {
			System.err.println(e);
		}
	} // end main
} // end PortScanner