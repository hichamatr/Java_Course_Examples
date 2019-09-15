package threads.interrupting_thread;
//public void interrupt()
//public static boolean interrupted()
//public boolean isInterrupted()

class Main extends Thread{  
public void run(){  
try{  
Thread.sleep(1000);  
System.out.println("task");  
}catch(InterruptedException e){  
throw new RuntimeException("Thread interrupted..."+e);  
}  
  
}  
  
public static void main(String args[]){  
	Main  t1=new Main ();  
t1.start();  
try{  
t1.interrupt();  
}catch(Exception e){System.out.println("Exception handled "+e);}  
  
}  
}  
