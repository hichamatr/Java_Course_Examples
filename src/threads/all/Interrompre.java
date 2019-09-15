package threads.all;


import java.util.Scanner ;

public class Interrompre
{ 
	public static void main (String args[])
	{ 
			Ecriture e1 = new Ecriture (" <1> ", 600) ;
			Ecriture e2 = new Ecriture (" <2> ", 500) ;
			
			e1.start() ;
			e2.start() ;
			
			System.out.println("taper une lettre pour bloquer <1>");
			new Scanner(System.in).nextLine();
			
			e1.interrupt() ; // interruption premier thread
			System.out.println ("\n*** Arret premier thread ***") ;
						
			System.out.println("taper une lettre pour bloquer <2>");
			new Scanner(System.in).nextLine();
				
			e2.interrupt() ; // interruption deuxième thread
			System.out.println ("\n*** Arret du deuxième thread ***") ;
			
			/*Thread th1 = new Thread() {
			public void run()
			{
			/*try {
					while (!Thread.currentThread().isInterrupted())
					{
						System.out.println("th1");
						
							Thread.sleep(500);
						} 
					}
				catch (InterruptedException e) {
				}
			}
		};

		th1.start();
		
		System.out.println("MAIN methode>> wait for a key to unterrupt th1!!");
		new Scanner(System.in).nextLine() ;
		th1.interrupt();
		System.out.println("Th1 was interrupted succefully!");*/
		
	}
}

class Ecriture extends Thread
{ 
	private String texte ;
	private long attente ;
	
	public Ecriture (String texte, long attente)
	{ 
		this.texte = texte ;
		this.attente = attente ;
	}
	
	public void run ()
	{ 
		try
		{ 
			while (true) // boucle infinie => de traitement
			{
				if (Thread.currentThread().isInterrupted()) return ;
				System.out.print (texte) ;
				Thread.sleep (attente) ;
			}
		}catch (InterruptedException e){ }
	}
}