package my_tps;

/********************************
 * author : Elhaloumi Hicham
 * exercise  : 2
 * date : 30/09/2017
 * title : Ex2_lievre class
 * description : the rabbit thread
 *******************************/

public class Ex2_lievre extends Thread{
	private int distance_lievre ;
	private int maxDistance ;// distance maximal à parcourir
	
	public Ex2_lievre(int maxDistance )
	{	
		this.distance_lievre = 0 ; 
		this.maxDistance = maxDistance ;
	}
	
	//thread lievre
	public void run()
	{
		while ( distance_lievre < maxDistance )
		{
			System.out.println("=> distance Lievre : " + distance_lievre + "m !");
			distance_lievre++;
			try
			{
				Thread.sleep(300);
			}catch(InterruptedException e ){}
			
			if ( distance_lievre == (maxDistance/2) )
			{
				System.out.println("===> lievre : Bon je vais dormir un petit peu ! ");
				try {
					sleep(10000);
				}catch (Exception e) {
					  System.out.println(e);
				}
			}
		}
		System.out.println(" *****arrivé du lievre*****");

	}
}
