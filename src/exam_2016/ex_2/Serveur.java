package exam_2016.ex_2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {

	public static void main(String[] args) throws IOException {
		
		ServerSocket serv_sock = new ServerSocket(8182);
		
		try {
			while(true)
			{
				System.out.println(" waiting for a new connection ...");
				Socket client_sock = serv_sock.accept() ;
				System.out.println("connection accepted...");
				
				new ClientHandler(client_sock).start();
							
			}
		}finally {
			serv_sock.close();
		}
		

	}

}
