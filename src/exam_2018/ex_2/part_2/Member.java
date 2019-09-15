package exam_2018.ex_2.part_2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author Hicham Abo ahmad
 * 
 * same notes (we need a shared lock between the threads) for this we passe Lock and Condition arguments in the constructor
 * through main method
 * 
 */
public class Member extends Thread{
	
	private static Point syncPoint ;
	
	private Lock my_lock;
	private Condition my_condition;
	
	
	public Member(Point syncPoint ,Lock lock , Condition condition)
	{
		this.syncPoint = syncPoint ;
		this.my_lock = lock ;
		this.my_condition = condition;
	}
	
	public  void run()
	{
		
		my_lock.lock();
		try
		{	
			syncPoint.setN( syncPoint.getN() - 1); //pour chaque new Thread je decremente, et le momoent ou j'arrive à 0 je libere tous
			syncPoint.setBlocked( !( syncPoint.getN() == 0 ) ); // s'il arrive à 0 => on va liberer et donc je doit actualiser l'attribut "block" en mettant false (ie : ne pas bloquer) dans le cas contraire ( different de 0 ) on laisse à true qui veut dire bloquer
			
			//si on a arrivé à 0 ( on va notifier tous les threads en attente )
			if ( !syncPoint.isBlock() )
			{
				System.out.println("\n\t" + Thread.currentThread().getName() + " hi i am here ^^ can we go?\n");
				my_condition.signalAll();
			}
			else //sinon on va attendre
			{
				try 
				{
					System.out.println( Thread.currentThread().getName() + " Va attendre");
					my_condition.await();// attendre jusqu'a une notification de la part du dernier thread qui arrive ( qui rend N egale à 0 )

				}catch (InterruptedException e) {
					e.printStackTrace();
				} 
			}
		}//end synchronization block
		finally {
			my_lock.unlock(); //liberation du lock
		}
		
		//Thread treatments
		for ( int i = 1 ; i < 6 ; i++ )
			System.out.println("Instruction "+i+ " du membre " + Thread.currentThread().getName() + "...");
		
	
		
	}
}
