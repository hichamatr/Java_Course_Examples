package threads.all;

class Priorités extends Thread{  
	final String v = "lock" ;
	 public void run(){
		 synchronized(v)
		 {
			 System.out.println("éxecution du thread nommé : "+Thread.currentThread().getName());/*	->ou bien getName()*/
			 System.out.println("sa priorité vaut donc :     "+Thread.currentThread().getPriority());/*->getPriority()*/ 
		 }
	   
	  }  
	 
	 public static void main(String args[]){  
		 
	Priorités m1=new Priorités(); 
	Priorités m2=new Priorités();
	
	/**modification des noms */
	m1.setName("<1>");
	m2.setName("<2>");
	
	/**modification de priorités */
	/*m1.setPriority(Thread.MIN_PRIORITY);  
	m2.setPriority(Thread.MAX_PRIORITY);*/
	  
	  m1.start();  
	  m2.start();  
	   
	 }  
}