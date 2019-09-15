package my_tps_2.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banque {
	
	private final double[] comptes ;
	private int nbComptes = 100 ; 
	private double solde = 1000; //soldeInitiale de chaque compte
	private Lock bankLock = new ReentrantLock(); 
	private Condition soldeSuffisant /* = bankLock.newCondition();*/;
	
	public Banque(int nbComptes, double solde)
	{
		soldeSuffisant = bankLock.newCondition();
		
		this.nbComptes = nbComptes;
		comptes = new double[ nbComptes <= 0 ? 100 : nbComptes] ;
		
		//initialisation de comptes
		for ( int i = 0 ; i < nbComptes ; i++)
		{
			comptes[i] = solde;
		}
		
		this.solde = solde;
	}
	
	public double soldeTotal()
	{
		double totalSolde = 0;
		
		for ( int i = 0 ; i < nbComptes ; i++  )
			totalSolde += comptes[i] ;
		
		
		return totalSolde ;
	}
	
	public synchronized void transferer_v2(int de , int vers, double montant) throws InterruptedException
	{
		while ( montant > comptes[de] ) 
		{
			System.out.println("waiting for solde!!"+ montant + ">" + comptes[de]);
			
			//wait
			wait();
		}
		
		comptes[de] -= montant ;
		System.out.printf(" => %10.2f (%d --> %d)", montant,de,vers);
		
		comptes[vers] += montant ;
		System.out.printf("		<=>Total = %10.2f\n",soldeTotal());
		
		//notify
		notifyAll();
		
		
	}
	
	public void transferer(int de , int vers , double montant) throws InterruptedException
	{
		bankLock.lock();
		
		try {
			 while ( montant > comptes[de] ) 
			 {		 
				   
					System.out.println("waiting for solde!!"+ montant + ">" + comptes[de]);
					
					//waiting 
					soldeSuffisant.await();
			 }
			 
				comptes[de] -= montant ;
				System.out.printf(" => %10.2f (%d --> %d)", montant,de,vers);
				
				comptes[vers] += montant ;
				System.out.printf("		<=>Total = %10.2f\n",soldeTotal());
				
				//notify
				soldeSuffisant.signalAll();
		}finally
		{
			bankLock.unlock();
		}
	}
	
	public int size()
	{
		return nbComptes ;
	}
	
	public double getSoldeInit()
	{
		return solde ;
	}
	
}
