package my_tps;

/********************************
 * author : El_Haloumi Hicham
 * exercise  : 1
 * date : 30/09/2017
 * title : Ex1_Afficheur class
 * description : clock treatments 
 *******************************/

public class Ex1_Afficheur implements Runnable{

	int counterSeconds , counterMinutes ;
	String minutes , seconds ;
	Ex1_Horloge horloge ;
	
	public Ex1_Afficheur( Ex1_Horloge horloge )
	{
		this.horloge = horloge ;
		this.counterSeconds = -1 ; // car : par la suite on va incrementer d'abord et puis on fait le traitement..
		this.counterMinutes = 0 ;
		this.minutes = "" ;
		this.seconds = "" ;
	}
	
	@Override
	public void run() //traitement du thread
	{
		while (true)
		{
			// traitement
			counterSeconds++ ;
			
			if ( counterSeconds == 60 )
			{
				counterSeconds = 0 ;
				counterMinutes ++ ;
			}
			
			if ( counterMinutes == 60)
				counterSeconds = counterMinutes = 0 ;
			
			//traitement d'affichage :
			seconds =  (counterSeconds < 10) ? "0" : "" ;
			if (counterSeconds < 10)
			{
				seconds = "0" ;
			}else
			{
				seconds = "" ;
			}/**/
			seconds += String.valueOf(counterSeconds) ; 
			
			minutes =  (counterMinutes < 10) ? "0" : "" ; 
			minutes += String.valueOf(counterMinutes) ;
			
			//actualisation du "JLabel" Horloge :
			horloge.setText(minutes + " : " + seconds);
			
			//attente d'une seconde
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
