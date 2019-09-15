package my_tps_2;

public class Transfert implements Runnable{
 
	private Banque banque ;
	private int de ;
	
	public Transfert(Banque banque , int de )
	{
		this.banque = banque ; 
		this.de = de ;
	}
	
	@Override
	public void run() {
		try {
			while ( true )
			{
				//get a random account
				int vers = (int) (banque.size()*Math.random()) ;
			
				//get a random amount of money < 1000
				double montant = banque.getSoldeInit()*Math.random(); //1000
				
				banque.transferer(de, vers, montant);
				Thread.sleep(100);
				
			}
		}catch ( InterruptedException e)
		{
			
		}
	}

}
