package threads.all;

public class Join_Test implements Runnable{

	public static void main(String[] args) 
	{
		
		Thread th = new Thread(new Join_Test()) ;
		th.start();
		
		System.out.println(">> Main thread instruction .. 1 ");
		System.out.println(">> Main thread instruction .. 2 ");
		
			try {
				th.join(); //^^
			} catch (InterruptedException e) {} /**/
		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		System.out.println(">> Main thread -- end");
	}
	
	public void run()
	{
		System.out.println("----TH---- BEGIN");
		for(int i=0 ; i<5 ; i++)
		{
			System.out.println(" <"+i+"> ");
			try{Thread.sleep(100);}catch(Exception e){}
			
		}
		System.out.println("----TH---- END");

	}
}
