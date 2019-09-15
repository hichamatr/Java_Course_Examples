package threads.producer_consumer;

public class Consommateur extends Thread {
    private Buffer buf;
    private int identité;
     public Consommateur(Buffer c, int n) {
        buf = c;
        this.identité = n;
    }
     
    public void run() {
        int val = 0;
        for (int i = 0; i < 10; i++) {
            val = buf.prendre();
            System.out.println("Consommateur #" + 
                  this.identité + " prend: " + val);
        }
    }
}