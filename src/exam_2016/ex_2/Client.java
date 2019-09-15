package exam_2016.ex_2;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
/**
 * 
 * @author Hicham abo ahmad
 * 
 * NOTE : ne faite pas try finally si on lance à l'interieur un new thread.. sauf qu'in est sur qu'on va pas faire un close avant que le thread finit son travaille..
 *
 */
public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Scanner sc = new Scanner(System.in) ;
		System.out.println("saisir une address : ");
		String adress = sc.nextLine();
		
		Socket sock = new Socket(adress, 8182) ;
		try {
			InputStream in = sock.getInputStream() ;
			byte b[] = new byte[100] ;
			
			int nbBytes = in.read(b);
			System.out.println(new String(b,0,nbBytes));
		}finally {
			sock.close();
		}
		
		
	}

}
