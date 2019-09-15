package threads.reentrant ;

class Reen{
	
	public synchronized void muhammed(){
		med();
		System.out.println("Muhammed");
	}
	public synchronized void med(){
		System.out.println("MED");
	}	
}



class Main {

	public static void main(String[] args) {
		Reen r = new Reen();
		
		Thread t1 = new Thread(){
			public void run(){
			r.muhammed();	
			}
		};
t1.start();
	}

}
