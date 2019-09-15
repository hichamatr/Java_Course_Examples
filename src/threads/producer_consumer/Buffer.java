package threads.producer_consumer;

public class Buffer {
    private int valeur;
    private boolean available = false;
    
    public synchronized int prendre() 
    {
        while (available == false)
        {
            try {
            		wait();
            	}
            catch (InterruptedException e) { }
        }
        available = false; notifyAll(); return valeur;
    }
    
    public synchronized void mettre(int val) 
    {
        while (available == true) 
        {
            try {
            		wait();
            	} catch (InterruptedException e) { }
        }
        valeur = val;available = true; notifyAll();
    }
}