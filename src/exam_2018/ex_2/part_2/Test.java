package exam_2018.ex_2.part_2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author Hicham Abo ahmad
 * 
 * this part could simply implemented using monitors ( extension of the part 1 ) but..
 * I will make this version with locks ( to have different ways of doing it ^^) 
 * 
 */
public class Test {

	public static void main(String[] args) {

		//creation du point de synchronisation
		//au depart tout dormeur doit se bloquer sur ce point
	    Point point = new Point(true,4) ; // true means bloqué ( c'est un choix )
		
	    //create shared Lock and Condition 
	    Lock lock = new ReentrantLock();
	    Condition condition = lock.newCondition();
	    
		//creation de 3 membre qui vont attendre le 4 eme
		Thread member_1 = new Member(point, lock , condition);
		Thread member_2 = new Member(point, lock , condition);
		Thread member_3 = new Member(point, lock , condition);
		
		Thread member_4 = new Member(point, lock , condition);
		
		//renommage des 4 threads
		member_1.setName("M_1");
		member_2.setName("M_2");
		member_3.setName("M_3");
		member_4.setName("M_4");
		
		
		//lancement des dormeurs
		member_1.start();
		member_2.start();
		member_3.start();
		
		//attente avant l'arrivé du 4 eme membre
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {}
		
		//arrivé du 4 eme
		member_4.start();

	}

}
