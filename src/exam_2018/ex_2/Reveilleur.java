package exam_2018.ex_2;

/**
 * 
 * @author Hicham Abo ahmad
 * 
 * Question : why not synchronized directly?
 *
 */
public class Reveilleur extends Thread{
	
	private static Point syncPoint ;
	
	public Reveilleur(Point syncPoint)
	{
		this.syncPoint = syncPoint ;
	}
	
	public void run()
	{
		synchronized(syncPoint)
		{
			System.out.println("\n\t =>Un reveilleur est venu \n");
			syncPoint.setBlocked(false); //debloquer
			syncPoint.notifyAll();
		}
		
	}

}
