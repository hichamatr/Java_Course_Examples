package java_rev;

public class Fille extends Mere
{
	private int e,f ;
	
	public Fille()
	{
		super();
		e = f = 0 ;
	}
	
	public Fille(int e , int f)
	{
		super(11);
		this.e = e ;
		this.f = f ;
	}
	
	/**/public void drive()
	{
		System.out.println(" Fille >> drive ");
	}
}