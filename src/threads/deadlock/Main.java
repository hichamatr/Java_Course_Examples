package threads.deadlock;

public class Main {

	public static void main(String[] args) {

final String obj1 = "Muhammed";
final String obj2 = "Essa";

Thread m1 = new Thread(){
	public void run(){
		synchronized(obj1){ System.out.println("m1 locked obj1");
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {}
 
		
		synchronized(obj2){ System.out.println("m1 locked obj2");
		}}};
	};

	Thread m2 = new Thread(){
		public void run(){
			synchronized(obj2){ System.out.println("m2 locked obj2");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {}
	 
			
			synchronized(obj1){ System.out.println("m2 locked obj1");
			}}};
		};	
	
	m1.start();
	m2.start();
	}}
