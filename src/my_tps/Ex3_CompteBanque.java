package my_tps;

/************************************************************
 * author : Elhaloumi Hicham
 * exercise  : 3
 * date : 30/09/2017
 * title : Ex3_CompteBanque class
 ************************************************************/
public class Ex3_CompteBanque {
	private int solde = 1600; //initialisation du solde pour tester le fonctionnement
	
	public int getSolde()
	{
		return solde ;
	}
	
	public void retirer(int montant)
	{
		this.solde -= montant ;
		System.out.println("----------- solde = " + this.solde);
	}
}
