package java_rev;

public class ExceptionsTest {

	public static void main(String[] args) {

		int x = 5 ;
		
		try
		{
			//int var = x / 0 ;
			
			System.out.println(" instruction ...");
			
			Thread.sleep(100);
			
		}
		catch (InterruptedException e) {
			System.out.println(e);
		}
		catch(Exception e)
		{
			System.out.println("..."+e);
		}
		finally {
			System.out.println(" --------- ");
		}

		System.out.println("\n************** Can you hear me?");
	}

}
