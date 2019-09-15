package my_tps;

/************************************************************
 * author : Elhaloumi Hicham
 * exercise  : 1
 * date : 30/09/2017
 * title : (main class) Ex1_Horloge class
 * description : GUI treatments and execution of the threads
 ************************************************************/

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ex1_Horloge extends JLabel{

	//private static final long serialVersionUID = 1L;
	
	public Ex1_Horloge()
	{
		//parametres du JLabel
		this.setHorizontalAlignment(JLabel.CENTER);
		Font font = this.getFont();
		this.setFont(new Font(font.getName(), font.getStyle(), 50));
		
		//initialisation
		Runnable afficheur = new Ex1_Afficheur(this);
		Thread thread = new Thread(afficheur);
		
		//lancement du thread
		thread.start();
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame(" exercice 1 : horloge et multithreading ") ;
		frame.setSize(256, 256); //taille de la fenetre
		frame.getContentPane().add( new Ex1_Horloge() ); // ajout du label au fenetre
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
	
	private class Ex1_Afficheur implements Runnable{

		int counterSeconds , counterMinutes ;
		String minutes , seconds ;
		Ex1_Horloge horloge ;
		
		public Ex1_Afficheur( Ex1_Horloge horloge )
		{
			System.out.println("PRIVAtE");
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
}
