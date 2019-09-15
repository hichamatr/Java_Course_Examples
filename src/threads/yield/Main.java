package threads.yield;
/**
 * @author 
	Thread.yield
	This static method is essentially used to notify the system that the current thread is willing to "give up the CPU" for a while.
	The general idea is that:
	The thread scheduler will select a different thread to run instead of the current one.
 *
 *javamex
 */

/**
 * 
 * @author 
 * La gestion des priorités dépend du Plateforme, parfois ne marche pas bien..
 * JVM est un esclave du plateforme..
 * nous on va raisoner comme si tout est bien
 *
 */
public class Main {

	public static void main(String[] args) {
		Thread producer, consumer ;
		
		producer = new Thread() {
			public void run()
			{
				for (int i = 0 ; i < 4 ; i++ )
				{
					System.out.println("producer" + i);
					
				}
				
			}
		};
		
		consumer = new Thread( new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0 ; i < 4 ; i++ )
				{
					Thread.yield();
					System.out.println("consumer " + i);
				}
			}
		}) ;
		
		producer.setPriority(Thread.MIN_PRIORITY);
		consumer.setPriority(Thread.MAX_PRIORITY);
		
		producer.start();
		consumer.start();
		/*
		System.out.println("====MAIN===1");
		System.out.println("====MAIN===2");
		System.out.println("====MAIN===3");*/
		
		
	}

}
