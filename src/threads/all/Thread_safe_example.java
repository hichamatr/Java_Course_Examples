package threads.all;

class TotalSeats
 {static public int totalSeats=2;}

class Reserver extends Thread{
	final Integer lock_var = 5 ; 
	private int seats; // seats number to reserve 
	private String name ;
	
	public Reserver(int seats, String name)
	{
		this.name=name ;
		this.seats = seats;
	}
	
	public boolean processing(int seats, String name)
	{
		System.out.println("Bonjour mr "+ name +", nombre de places disponible est : " + TotalSeats.totalSeats + " (vous demandez : "+seats+")." );
		
		if (seats>TotalSeats.totalSeats) {return false;} 
		else 
		{
			TotalSeats.totalSeats -= seats;
			return true;
		}
	}
	
	public void run() {
		 
		//synchronized(lock_var)  
		//{
			boolean b = this.processing(seats, name);
		
		 if(b==true)
			 System.out.println("Félicitation mr :" + name +", demande bien effectué");
		 else
			 System.out.println("Pardon mr : "+ name+",espace insuffisant");
		//}
	  }
}

public class Thread_safe_example {
	
public static void main(String[] args){
	Reserver pt1 = new Reserver(2," hicham ");
	Reserver pt2 = new Reserver(2, " marouane ");	
	//Thread e = new Ecrit("  <<<3>>>  ", 6 ,100) ;
	pt1.start();
	pt2.start();
	//e.start();
}
}