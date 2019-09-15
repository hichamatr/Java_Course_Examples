package java_rev;

public class TestJava8 {

	public static void main(String[] args) {

		I i =  ()->System.out.println("hello guy !! you are using lambda expressions");
		i.affiche();

	}

}

interface I
{
	//new feature
	public void affiche();
}