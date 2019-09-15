package threads.inter_comm;

class Customer{  
int amount=5000;  
  
synchronized void withdraw(int amount){  
                         System.out.println("going to withdraw...");  
  
if(this.amount<amount){  
System.out.println("Less balance; waiting for deposit...");  
try{  
	wait();
}catch(Exception e){}  
}  
this.amount-=amount;  
System.out.println("withdraw completed...");  
}  
  
synchronized void deposit(int amount){  
System.out.println("going to deposit...");  
this.amount+=amount;  
System.out.println("deposit completed... ");  
notify();  
}  
}  
  
class Main{  
public static void main(String args[]){  
	
final Customer c=new Customer(); 

new Thread(){  
public void run(){c.withdraw(6500);}  
}.start();  

new Thread(){  
public void run(){c.deposit(5000);}  
}.start();  
  
}}  