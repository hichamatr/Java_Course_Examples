package synchronizationDemo;

public class Main {

	int counter = 0 ;
	
	public static void main(String[] args) {
		
		Main res = new Main();
		
		Thread r1 = new Thread() {
			public void run()
			{
				res.retirer();
			}
		};
		
		Thread r2 = new Thread() {
			public void run()
			{
				res.retirer();
			}
		};
		
		Thread r3 = new Thread() {
			public void run()
			{
				res.retirer();
			}
		};
		
		Thread a = new Thread() {
			public void run()
			{
				res.ajouter();
			}
		};
		
		Thread a2 = new Thread() {
			public void run()
			{
				res.ajouter();
			}
		};
		
		Thread a3 = new Thread() {
			public void run()
			{
				res.ajouter();
			}
		};
		
		a.setName("A");
		a.setName("A2");
		a.setName("A3");
		r1.setName("R1");
		r2.setName("R2");
		r3.setName("R3");
		
		//lancement des threads
		r1.start();
		r2.start();
		r3.start();
		a.start();
		a2.start();
		a3.start();

	}

	synchronized public void retirer()
	{
		while (counter <= 0)
		{
			System.out.println(Thread.currentThread().getName()+ " -> is waiting..");
			
			try {
				wait();
			}catch(InterruptedException e){}
		}
		counter--;
		System.out.println(Thread.currentThread().getName()+ " retirement DONE counter = " + counter);
	}
	
	synchronized public void ajouter()
	{
		System.out.println(Thread.currentThread().getName()+" -> is adding ...");
		counter++;
		System.out.println(Thread.currentThread().getName()+ " adding DONE counter = " + counter);
		
		System.out.println("en train de notifier (5 sec)");
		try {
			Thread.sleep(5000);	
		}catch(Exception e) {}
		
		notifyAll();
		
		System.out.println("apres notify mais pas encore sorti du thread");
		try {
			Thread.sleep(5000);	
		}catch(Exception e) {}		
	}
}
