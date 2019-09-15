package exam_2018.ex_2.part_2;


/**
 * @author Hicham abo ahmad
 * 
 * Rendez vous paradigm implementation
 */
public class Point {
	
	//wait or not
	private boolean block; 
	
	//max nb of threads that can wait at the "rendezvous" point
	private int N ;
	
	//creator of the class
	public Point(boolean block, int N)
	{
		this.block = block ;
		this.N = N ;  
	}
		
	//getter of the attribute block
	public boolean isBlock() { return block ;}
	
	//setter of the attribute block
	public void setBlocked(boolean block) { this.block = block ;}

	//getter and setter of N
	public int getN() {
		return N;
	}

	public void setN(int n) {
		N = n;
	}
	
	
	
	
	
}
