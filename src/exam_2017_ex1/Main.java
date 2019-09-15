package exam_2017_ex1;


public class Main {

	public static void main(String[] args) {
		
		/******* part 1 of the exercice ********\
			//creation des 3 threads
			Thread a = new Dormeur_part1(" A ") ;
			Thread b = new Dormeur_part1(" B ") ;
			Thread c = new Dormeur_part1(" C ") ;
			
			//lancement des 3 threads
			a.start();
			b.start();
			c.start();
		 \***************************************/
		
		//creation des 3 threads
		Thread c = new Thread(new Dormeur_part2(" C ", null) );
		Thread b = new Thread(new Dormeur_part2(" B ", c)) ;
		Thread a = new Thread(new Dormeur_part2(" A ", b)) ;
		
		//lancement des 3 threads
		a.start();
		b.start();
		c.start();
		
		
	}

}
