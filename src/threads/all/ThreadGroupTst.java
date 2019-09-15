package threads.all;


public class ThreadGroupTst {

public static void main(String[] args) {

	ThreadGroup tg = new ThreadGroup("groupe");
	
	Thread t1 = new Thread(tg,new Ecrit(" <1> ", 100 , 300 ), "n°1");
	Thread t2 = new Thread(tg,new Ecrit(" <2> ", 100 , 400 ), "n°2");
	Thread t3 = new Ecrit(" <3> ", 10 , 1000) ;
	t1.start();
	////
	t2.start();
	t3.start();
	/*try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {	}
	tg.stop();*/
	
}

}