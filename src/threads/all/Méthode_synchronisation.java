package threads.all;

//TODO : recreate the example with anonymous classes

class Table{  
	  
public /*synchronized*/ void printTable(int n){//methode [non] synchronisé  
   for(int i=1;i<=3;i++)
   {  
     System.out.println(Thread.currentThread().getName() + "---"+n*i);  
     try{  
      Thread.sleep(100);  
     }catch(Exception e){System.out.println(e);}  
   }  
 }  
}  

class MyThread1 extends Thread
{
	Table t;  
	MyThread1(Table t)
	{  this.t=t;  } 
	
	public void run()
	{  t.printTable(5);  }
}

class MyThread2 extends Thread
{
	Table t;
	MyThread2(Table t)
	{  this.t=t;  }
	public void run()
	{  t.printTable(100);  }
}  
  
public class Méthode_synchronisation{
	public static void main(String args[]){
		Table obj = new Table();//REMARQUER ici on a un problème 
		
			MyThread1 t1=new MyThread1(obj);
			MyThread2 t2=new MyThread2(obj);
			
			t1.setName("[ 5 ]");
			t2.setName("[100]");

		t1.start();  
		t2.start();  
}  
}  
