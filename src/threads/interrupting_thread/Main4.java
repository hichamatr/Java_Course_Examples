package threads.interrupting_thread;
public class Main4 extends Thread{  
  
public void run(){  
for(int i=1;i<=8;i++){  
if(Thread.interrupted()){  
System.out.println("  interrupted thread"+Thread.currentThread().getName());  
}  
else{  
System.out.println(" normal thread"+Thread.currentThread().getName());  
}  
  
}//end of for loop  
}  
  
public static void main(String args[]){  
  
	Main4 t1=new Main4();  
	Main4 t2=new Main4();  
  
t1.start();  
t1.interrupt();  
  
t2.start();  
  
}  
}  