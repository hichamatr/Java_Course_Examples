package java_rev;

import java.util.ArrayList;

interface MyInterface
{
	/*public abstract*/	        void desc();
	/*abstract public*/ 	    int  minList(ArrayList<Integer> lst) ;
	
	/* public static final*/    String GLOB ="" ;
}

 public abstract class  MyAbstClass
{
  public void print() {
	  
 }
  
   public abstract void echo() ;
  
}

 class Desc extends MyAbstClass{

	@Override
	public void echo() {
		// TODO Auto-generated method stub
		
	}
	 
 }

 class Conc implements MyInterface
{

	@Override
	public void desc() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int minList(ArrayList<Integer> lst) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

abstract class OtherAbst extends MyAbstClass implements MyInterface
{
	public void print() 
	{
		
	}
}/**/

