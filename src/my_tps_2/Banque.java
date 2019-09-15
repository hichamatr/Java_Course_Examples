package my_tps_2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banque {
	
	private final double[] comptes ;
	private int nbComptes = 100 ; 
	private double solde = 1000; //soldeInitiale de chaque compte
	private Lock bankLock = new ReentrantLock(); 
	
	public Banque(int nbComptes, double solde)
	{
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
	
	
	public void transferer(int de , int vers , double montant)
	{   
		bankLock.lock();
		if ( montant > comptes[de]) return ; //ignore !
		
		else { // if montant <= comptes[de]
			/*
			 * ******************************************************************************************************************
			 * an other thread can reach before us here to get the Lock, during this we can have 
			 * less money and instead of this, we realize the transaction => a problem for this we deal with
			 * conditions...
			 * 
			 * so we need to protect this section of the code, we need to be sure that the other threads will not stop us ( clean the account )
			 * *******************************************************************************************************************
			 * 
			 * */
			///LOCKING PART
			
			try {
				//System.out.println("\n*********\n******** " + (montant>comptes[de]) +"***********\n*************");
				//System.out.println("locked!");
				//synchronized (this)
				//	{
						System.out.print (" (*) "+Thread.currentThread());
						comptes[de] -= montant ;
						System.out.printf(" => %10.2f (%d --> %d)", montant,de,vers);
						comptes[vers] += montant ;
						System.out.printf("		<=>Total = %10.2f\n",soldeTotal());
				//	}
					
			}finally {
				///UNLOCKING
				 bankLock.unlock();
			}
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
