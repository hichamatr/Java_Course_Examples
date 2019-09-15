package exam_2017_ex1;

public class Dormeur_part1 extends Thread{

	String nom = "" ;
	
	//constructor
	public Dormeur_part1(String nom)
	{
		this.nom = nom ;
	}
	
	public void run()
	{
		//wait quelques secondes
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e)
		{}
		
		//message de fin
		System.out.println("\nJe suis "+ nom + " j'ai fini!");
	}
}
