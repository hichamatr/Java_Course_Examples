package exam_2018.ex_2;
/**
 * 
 * @author Hicham Abo ahmad
 * 
 * Question :(*) why not synchronized directly? => faire un test pour voir ! (rep : l'objet 'this' n'est pas unique ( on lance plusieurs dormeurs ) la synchronisation doit se faire sur un objet partagé !! rappelez vous le cours) 
 *			 (*) why not wait and notify directly? (we have made syncPoint.wait and syncPoint.notifyAll) --it is an Object method (rep : on doit faire wait and notify sur un moniteur commun! pour synchroniser )
 *
 */
public class Dormeur extends Thread{
	
	private static Point syncPoint ;
	
	public Dormeur(Point syncPoint)
	{
		this.syncPoint = syncPoint ;
	}
	
	public  void run()
	{
		synchronized (syncPoint) {
			
			//if blocked => wait
			if ( syncPoint.isBlock() ) 
			{
				try 
				{
					System.out.println("le dormeur :" + Thread.currentThread().getName() + " va attendre");
					syncPoint.wait();// attendre jusqu'a une notification de la part d'un reveilleur
				}catch (InterruptedException e) {
					e.printStackTrace();
				} 
			}
		}//end synchronization block -- we don't have to synchronize the whole method, but this part is mandatory
		
		System.out.println("\nle dormeur :" + Thread.currentThread().getName() + "est reveillé\n");

		//Thread treatments -- any treatments here
		for ( int i = 1 ; i < 6 ; i++ )
			System.out.println("Instruction "+i+ " du dormeur " + Thread.currentThread().getName() + "...");
		
	
		
	}
}
