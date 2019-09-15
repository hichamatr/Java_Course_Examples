package exam_2017_ex1;

import java.util.ArrayList;

public class Dormeur_part2 implements Runnable{

	String nom = "" ;
	Thread antecedant = null ;
	
	//constructor
	public Dormeur_part2(String nom , Thread predecessor )
	{
		this.nom = nom ;
		this.antecedant = predecessor ;
	}
	
	//set_pred method
	public void set_pred(Thread predecessor)
	{
		this.antecedant = predecessor ;
	}
	
	public void run()
	{
		//wait quelques secondes pour que les 3 threads seront active
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e)
		{}
		
		//s'il possede un antecedant
		if ( this.antecedant != null )
		{
			try 
			{
				antecedant.join();
				
			} catch (InterruptedException e) 
			{}
		}
				
		
		//message de fin
		System.out.println("\nJe suis "+ nom + " j'ai fini!");
	}

}
