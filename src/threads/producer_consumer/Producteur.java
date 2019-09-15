package threads.producer_consumer;

// Producteur.java
public class Producteur extends Thread 
{
    private Buffer buf;
    private int identité;
    public Producteur(Buffer c, int n) 
    {
        buf = c; this.identité = n;
    }		
    
public void run() {
   for (int i = 0; i < 100; i++) {
       buf.mettre(i);
       System.out.println("Producteur #" + this.identité 
                        + " met : " + i);
       try { sleep((int)(Math.random() * 100));}
       catch (InterruptedException e) { }
       }
    }
}