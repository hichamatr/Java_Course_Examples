package my_tps;
/********************************
 * author : Elhaloumi Hicham
 * exercise  : 3 
 * date : 30/09/2017
 * title : main class
 * description : 
 *******************************/
/* description :
 * explication du résultat obtenue avant la synchronisation 
 * de la méthode "demandeRetrait" de la classe Ex3_SanjiEtNamiJob :
 * => puisque les deux threads (1-sanji) et (2-robin) sont executés en "parallel" donc on aura
 * 	  des cas où les transactions s'intercalent l'une dans l'autre en cours d'execution du transaction..
 * => l'idée c'est de protéger la portion du code qui se pose le probleme et c'est effectivement ce qu'on a fait 
 * 	  pour la methode "demandeRetrait"
 */
public class Ex3_Main {

	public static void main(String[] args) {
		Runnable sanji_robin = new Ex3_SanjiEtNamiJob();
		
		Thread sanji = new Thread(sanji_robin);
		
		Thread robin = new Thread(sanji_robin);
		
		sanji.setName(" sanji! ");
		robin.setName(" robin! ");
						
		robin.start();
		sanji.start();
	}

}
