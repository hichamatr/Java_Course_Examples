package my_tps_2.locks;

public class MainClass {

	public static void main(String[] args) {
		Banque banque = new Banque(100,1000) ;
		for ( int de = 0 ; de < 100 ; de++)
		{
			Runnable r = new Transfert(banque,de);
			new Thread(r).start();
		}

	}

}
