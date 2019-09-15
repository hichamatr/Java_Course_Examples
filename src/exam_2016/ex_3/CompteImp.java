package exam_2016.ex_3;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CompteImp extends UnicastRemoteObject implements Compte{

	private double solde ;
	
	protected CompteImp(double solde) throws RemoteException {
		super();
		
		this.solde = solde ;
	}

	@Override
	public void debiter(double montant) throws RemoteException {
		solde -= montant ;
	}

	@Override
	public void crediter(double montant) throws RemoteException {
		solde+=montant ;
		
	}

	@Override
	public double getSolde() throws RemoteException {
		System.out.println("### Message...");
		return solde;
	}

}
