package exam_2018.ex_2;

public class Test {

	public static void main(String[] args) {

		//creation du point de synchronisation
		//au depart tout dormeur doit se bloquer sur ce point
	    Point point = new Point(true) ; // true means bloqué ( c'est un choix )
		
		//creation de 3 dormeurs et un réveilleur sur le meme point
		Thread dormeur_1 = new Dormeur(point);
		Thread dormeur_2 = new Dormeur(point);
		Thread dormeur_3 = new Dormeur(point);
		
		Thread reveilleur = new Reveilleur(point);
		
		//renommage des threads
		dormeur_1.setName("D_1");
		dormeur_2.setName("D_2");
		dormeur_3.setName("D_3");
		
		//lancement des dormeurs
		dormeur_1.start();
		dormeur_2.start();
		dormeur_3.start();
		
		//attente avant l'arrivé du reveilleur
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {}
		
		//arrivé d'un reveilleur
		reveilleur.start();

	}

}
