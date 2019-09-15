package java_rev;

public class StaticTests {

	static int var = 3 ;
	
	public static void main(String[] args) {
	
	System.out.println("var = " + StaticTests.var);
		
	StaticTests s = new Ss() ;

	System.out.println("var = " + var);
	
	s = new Mm() ;
	
	System.out.println("var = " + var);
		
	}
}

class Ss extends StaticTests
{
	Ss()
	{
		var = 4 ;
	}
}

class Mm extends StaticTests
{
	Mm()
	{
		var = 7 ;
	}
}

class xx {
	xx()
	{
		StaticTests.var = 0 ;
	}
}