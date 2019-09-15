package exam_2016.ex_2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;

public class ClientHandler extends Thread{
	
	private Socket sock ;
	
	public ClientHandler(Socket sock)
	{
		this.sock = sock ;
	}
	
	public void run()
	{
		try 
		{
			try {
				OutputStream out = sock.getOutputStream();
				out.write( new Date().toString().getBytes() );
			}finally {
				sock.close();
			}
			
		} catch (IOException e) 
		{}
	}
}
