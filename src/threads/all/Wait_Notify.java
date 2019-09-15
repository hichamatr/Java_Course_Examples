package threads.all;

// TODO : recreate the example with anonymous class anonymous class
class client
{    
	 synchronized void tache1()
	{  
		System.out.println("[je suis la tache 1]");   
		System.out.println("la tache (1) est besoins de la tache (2)  pour terminer ...");  
		try{
			wait();
		}catch(Exception e){}  
						
		System.out.println("tache 1 effectué ... ");  
	}  
	
	 synchronized void tache2()
	{ 
		
		System.out.println("[je suis la tache 2]");  
		System.out.println("la tache 2 est bien effectué ");  
		notify();  
	} 
}

/**l'objet thread qui va nous faire appeler la tache 1*/
class T1 extends Thread
{	client cc ;

	public T1(client c)
	{
		cc=c ;
	}
	
	public void run()
	{	cc.tache1();	}  
}

/**l'objet thread qui va nous faire appeler la tache 2*/
class T2 extends Thread
{	client cc ;
public T2(client c)
{
	cc=c ;
}
public void run()
{	cc.tache2();	}  
}


public class Wait_Notify
{  
	public static void main(String args[])
	{  
		final client c=new client(); 
		
		Thread t1 =new T1(c) ;
		Thread t2 =new T2(c) ;
		
		t1.start();
		//new java.util.Scanner(System.in).nextLine() ; //cette exemple justement pour voir
		t2.start();
	   }
}
/*new Thread(){  
public void run(){c.tache1();}  
}.start();  
new Thread(){  
public void run(){c.tache2();}  
}.start();*/