package exam_2016.ex_1;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		//1. creation et lancement des deux threads 
		Thread thread_1 = new Thread() {
			public void run()
			{
				for (int i = 0 ; i < 10 ; i++ )
				{
					//attendre un temps aléatoire entre 0 et 200
					int randTime = (int) (Math.random()*200) ;
					
					try {
						Thread.sleep(randTime);
					} catch (InterruptedException e) 
					{}
					
					System.out.println(Thread.currentThread().getName());
					
					//2. pour afficher en alternance (meme c'est pas toujour le cas)
					//yield();
				}
			}
		};
		
		Thread thread_2 = new Thread() {
			public void run()
			{
				for (int i = 0 ; i < 10 ; i++ )
				{
					//attendre un temps aléatoire entre 0 et 200
					int randTime = (int) (Math.random()*200) ;
					
					try {
						Thread.sleep(randTime);
					} catch (InterruptedException e) 
					{}
					
					System.out.println(Thread.currentThread().getName());
					
					//2. pour afficher en alternance (meme c'est pas toujour le cas)
					// yield();
				}
			}
		};
		//renommage
		thread_1.setName("T_1");
		thread_2.setName("T_2");
		
		//lancement du thread
		thread_1.start();
		thread_2.start();
		
		// attente des deux threads
		thread_1.join();
		thread_2.join();
		
		// un msg avant de sortir du main
		System.out.println("END main");
	}

}
