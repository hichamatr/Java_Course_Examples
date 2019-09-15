package threads.interrupting_thread;
class Main2 extends Thread{  
public void run(){  
try{  
Thread.sleep(1000);  
System.out.println("task");  
}catch(InterruptedException e){  
System.out.println("Exception handled "+e);  
}  
System.out.println("thread is running...");  
}  
  
public static void main(String args[]){  
	Main2 t1=new Main2();  
t1.start();  
  
t1.interrupt();  
  
}  
}  