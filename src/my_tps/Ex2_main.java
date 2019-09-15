package my_tps;

/**************************************************************
 * author : Elhaloumi Hicham
 * exercise  : 2
 * date : 30/09/2017
 * title : (main class) Ex2_main
 * description : running of the two threads (turtle and rabbit)
 **************************************************************/

public class Ex2_main{

	public static void main(String[] args) {
		int distanceCourse = 10 ; // 10 metres
		
		new Ex2_lievre(distanceCourse).start() ;
		new Ex2_tortue(distanceCourse).start() ;
		
	}

}
