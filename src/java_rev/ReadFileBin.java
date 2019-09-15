package java_rev;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadFileBin {

	public static void main(String[] args) {
		FileInputStream fin;
		FileOutputStream fout ;
		
		try 
		{
			fin = new FileInputStream("hicham.txt");
			DataInputStream entree = new DataInputStream( new BufferedInputStream(fin)) ;
			// OR : DataInputStream entree = new DataInputStream(fin) ;
			
			fout = new FileOutputStream("ATR.txt") ;
			DataOutputStream sortie = new DataOutputStream( new BufferedOutputStream(fout));
			
			
			String line = "" ;
			while ( (line = entree.readLine()) != null ) {
				System.out.println(line);
				sortie.write(line.getBytes());
			}
			
			sortie.close();
			fout.close();
			
			entree.close();
			fin.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
