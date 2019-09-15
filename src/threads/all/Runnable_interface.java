package threads.all;


public class Runnable_interface
{ 
	public static void main (String args[])
	{ 
		Ecrit2 e1 = new Ecrit2 (" <1> ", 4, 100) ;
		Ecrit2 e2 = new Ecrit2 (" <2> ", 4, 100) ;
		Ecrit2 e3 = new Ecrit2 (" <3> ", 10, 100) ;
		
		Thread t1 = new Thread(e1) ; /**on ne peut pas faire directement "e1.start()" car ici on a implémenter l'interface Runnable qui ne contient 
									  **que la méthode run() **/
		Thread t2 = new Thread(e2) ;
		Thread t3 = new Thread(e3) ;
		
		t1.start();
		t2.start();
		t3.start();	
	}
}
class Ecrit2 implements Runnable
{ 
	private String texte ;
	private int nb ;
	private long attente ;
	
	public Ecrit2 (String texte, int nb, long attente)
	{
		this.texte = texte ; this.nb = nb ;
		this.attente = attente ;
	}
	public void run ()
	{ 
		try
		{ 
		  for (int i=0 ; i<nb ; i++)
		  { 
			System.out.print (texte) ;
			Thread.sleep (attente) ;
		  }
		}catch (InterruptedException e) {} // imposé par "sleep" on va voir sa particularité par la suite
	}
}