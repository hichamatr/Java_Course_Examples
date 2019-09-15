package java_rev;

public class Inheritence {

	public static void main(String[] args) {
		
		Mere obj;// = new Mere() ;
		//((Mere)obj).drive();
		
		obj = new Fille();
		((Fille)obj).drive();
	}

}

