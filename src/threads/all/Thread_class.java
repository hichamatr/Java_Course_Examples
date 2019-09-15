package threads.all;


public class Thread_class
{  
	public static void main (String args[])
	{  
		Ecrit e1 = new Ecrit (" <1> ", 4, 200) ;
		Ecrit e2 = new Ecrit (" <2> ", 4, 200) ;
		Ecrit e3 = new Ecrit (" <3> ", 10, 200) ;
		
		/**/
		e1.start() ;
		e2.start() ;
		e3.start() ;
		//new java.util.Scanner(System.in).nextLine() ;
		/**e1.run() ; 
		e2.run() ;
		e3.run() ;**/
	}
}

class Ecrit extends Thread
{ 
	private String texte ;
	private int n ; //nombre de fois à executer (boucle)
	private long attente ;
	
	public Ecrit (String texte, int n, long attente)
	{
		this.texte = texte ; this.n = n ;
		this.attente = attente ;
	}
	
	public void run ()
	{
		try
		{ 
		  for (int i=0 ; i<n ; i++)
		  { 
			System.out.print (texte) ;
			Thread.sleep (attente) ; //static méthode
		  }
		}catch (InterruptedException e) {} // imposé par "sleep" on va voir sa particularité par la suite
	}
}