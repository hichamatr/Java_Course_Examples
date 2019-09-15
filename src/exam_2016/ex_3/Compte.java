package exam_2016.ex_3;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Compte extends Remote{
	public void debiter(double montant) throws RemoteException ;
	public void crediter(double montant) throws RemoteException;
	public double getSolde() throws RemoteException;
}
