package threads.all;

public class DaemonThread2 {
    public static void main(String args[]) {

        Thread t = new Thread(new Secondaire());
        t.setDaemon(true);
        t.start();
        for (int i = 0; i < 6; i++) {
            System.out.print(" 1 ");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }
        }
        System.out.println("Fin");
    }
}
 
class Secondaire implements Runnable {
    public void run() {
        while (true) {
            System.out.print(" 2 ");
            try {
                Thread.sleep(300);
            } catch (InterruptedException ie) {
                    ie.printStackTrace();
            }
        }
    }
}
