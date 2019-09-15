package exam_2018.ex_2;

/**********************************
 * @author Hicham abo ahmad
 * Sync point implementation
 * 
 **********************************/
public class Point {
	
	//wait or not
	private boolean block; 
	
	//creator of the class
	public Point(boolean block)
	{
		this.block = block ;
	}
		
	//getter of the attribute
	public boolean isBlock() { return block ;}
	
	//setter of the attribute
	public void setBlocked(boolean block) { this.block = block ;}
	
	
	
}
