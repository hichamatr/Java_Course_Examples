package exam_2018.ex_1;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTest {

	public static void main(String[] args) throws UnknownHostException, IOException  {
		
		Socket sock = new Socket("localhost",12200);
		
		OutputStream out  =  sock.getOutputStream() ;
		PrintWriter pr = new PrintWriter(out,true) ;
		pr.println("hello \n i am hicham \n ok \n ok \n i hope you are ok now \n thank you \n please can you finish ?");
		
		while (true) ; // we'll still here until killing the client 
		
		//sock.close();
		
		
	}

}
