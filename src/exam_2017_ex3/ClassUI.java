package exam_2017_ex3;

/**
 * 
 * @author Hicham abo ahmad
 * Exercice 3 => { exam : 2017 }
 * ********************************
 * Classe client (lancement du client)
 ****************************************/

import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Scanner;

public class ClassUI {
	
	public static void main(String args[])
	{
		try {
			Client cl = new Client() ;
			
			//Commande line interface arguments
			/*
			 * //java ClassUI url pseudo
			 * if ( args.length != 2 )
			{
				System.out.println("Mauvaise arguments ! ");
				System.exit(-1);
			}
			cl.connect(args[0],args[1]);*/
			
			/**pour tester sous eclipse*/
			System.out.println("saisir un pseudo pour votre client SVP:");
			cl.connect("rmi://localhost:1099/chatServer", (new Scanner(System.in)).nextLine());
			
			
			LineNumberReader in = new LineNumberReader(new InputStreamReader(System.in));
			String str = null ;
			
			System.out.print("tape something please : ");
			while ( (str= in.readLine())!=null)
			{
				if ( str.equals("x"))
				{
					cl.disconnect();
					System.exit(-1);
				}else
				{
					cl.send(str);
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
