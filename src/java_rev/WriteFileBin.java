package java_rev;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFileBin {

	public static void main(String[] args) {

		FileOutputStream fout ;
		DataOutputStream sortie ;
		
		try {
			  fout = new FileOutputStream("hicham.txt") ;
			  sortie = new DataOutputStream( new BufferedOutputStream(fout));
			 // OR simply : DataOutputStream sortie = new DataOutputStream( fout ) ;

			 String str = "hello\n i am hXY\n thank you \n nice to meet you\n" ;
			 sortie.write(str.getBytes());
			 
			 sortie.close();
			 fout.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
