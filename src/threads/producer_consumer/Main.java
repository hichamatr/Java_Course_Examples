package threads.producer_consumer;

//Main.java
public class Main {
 public static void main(String[] args) 
 {
     Buffer c = new Buffer();
     
     Producteur p1 = new Producteur(c, 1);
     Producteur p2 = new Producteur(c, 2); 
     Producteur p3 = new Producteur(c, 3);

     Consommateur c1 = new Consommateur(c, 1);
     Consommateur c2 = new Consommateur(c, 2);
     Consommateur c3 = new Consommateur(c, 3);
     
     //lancement des producteurs
     p1.start();p2.start();p3.start();
     
     //lancement des consommateurs
     c1.start();c2.start();c3.start();
     }
 }