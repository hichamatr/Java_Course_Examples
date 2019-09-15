package java_rev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AnonymousClasses {

	public static void main(String[] args) {
		
		/*ArrayList<Integer> al = new ArrayList<Integer>() ;
		al.add(99);
		al.add(98);
		al.add(12);
		al.add(66);*/
		
		ArrayList<Integer> al = new ArrayList<Integer>() {{
			add(99);
			add(88);
			add(77);
			add(66);
		}};
		
		//avant le trie
		System.out.println(al);
		
		//sorting
		Collections.sort(al);
		
		//apres
		System.out.println(al);
		
		//Comparator<Integer> dec = new Decr() ;
		Comparator<Integer> dec = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				if ( o1 < o2) return 1 ;
				else if ( o1 > o2) return -1 ;
				return 0;
			}
		};
		
		Collections.sort(al , dec);
		System.out.println(al);
		
		//Comparator<Integer> croiss = new Croiss();
		Comparator<Integer> croiss = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if ( o1 < o2) return -1 ;
				else if ( o1 > o2) return 1 ;
				return 0;
			}
			
		};
		
		Collections.sort(al, croiss);
		System.out.println(al);
		
		
	}
}

class Croiss implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		if ( o1 < o2) return -1 ;
		else if ( o1 > o2) return 1 ;
		return 0;
	}
	
}

class Decr implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		if ( o1 < o2) return 1 ;
		else if ( o1 > o2) return -1 ;
		return 0;
	}
	
}
