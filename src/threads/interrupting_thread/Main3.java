package threads.interrupting_thread;
class Main3 extends Thread{  
  
public void run(){  
for(int i=1;i<=5;i++)  
System.out.println(i);  
}  
  
public static void main(String args[]){  
	Main3 t1=new Main3();  
t1.start();  
  
t1.interrupt();  
  
}  
}  