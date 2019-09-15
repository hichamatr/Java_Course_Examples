package exam_2016.ex_3;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Serveur {

	public static void main(String[] args) {
		try {
			System.out.println("Serveur : construction de l'implementation");
			Compte cpt = new CompteImp(2000.0);
			System.out.println("Objet compte enregistré dans RMIregistry");
			
			//question c
			///dynamically running of the rmiregistry
			Registry register = LocateRegistry.createRegistry(1099);
			register.rebind("compteObj",cpt) ;
			
			//or this :
			//this requires the running of rmiregistry before
			//Naming.rebind("compteObj",cpt) ;
			
			System.out.println("Attente des invocations des clients");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}// end main
}//end server classe
