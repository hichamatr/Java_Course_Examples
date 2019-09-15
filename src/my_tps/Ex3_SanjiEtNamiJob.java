package my_tps;

/************************************************************
 * author : Elhaloumi Hicham
 * exercise  : 3
 * date : 30/09/2017
 * title : Ex3_SanjiEtNamiJob class
 * description : the thread that execute 6 transactions (for example) (for each client) "in our example sanji and robin.
 ************************************************************/

public class Ex3_SanjiEtNamiJob implements Runnable{

	final static String key= "FF" ;
	private Ex3_CompteBanque compte = new Ex3_CompteBanque() ;
	
	@Override
	public void run() {
		for (int i=0 ; i<6 ; i++) // 6 transaction à titre d'exemple
		{
			System.out.println("i = " + i );
			demandeRetrait(200);
			//System.out.println("name : " + Thread.currentThread().getName());
			if ( compte.getSolde() <= 0 )
				System.out.println("compte à Decouvert ! " + " => " + Thread.currentThread().getName());
		}
	}
	public synchronized void demandeRetrait(int somme)
	{
		synchronized(this)
		{
			//tests
			if ( somme > this.compte.getSolde() )
				System.out.println("=> Pas assez d’argent pour : " + Thread.currentThread().getName());
			else
			{
				System.out.println(Thread.currentThread().getName() + " est sur le point de retirer.");
				//sleep 1000ms
				try {
					System.out.println(Thread.currentThread().getName() + " dort!");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println(e);
				}
				
				//reveille!
				System.out.println(Thread.currentThread().getName() + " reveillé.");
				compte.retirer(somme);
				System.out.println(Thread.currentThread().getName() + " à compléter le retrait");
			}
		}

	}

}
