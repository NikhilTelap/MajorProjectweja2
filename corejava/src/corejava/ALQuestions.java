package corejava;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;

public class ALQuestions {
	
	public static void main(String[] args) {
		
		ArrayList al = new ArrayList();
		al.add(20);
		al.add(20);
		al.add(20);
		al.add(10);
		al.add(21);
		al.add(10);

		
		
	HashSet set = new HashSet(al);		
	System.out.println(al);
	System.out.println(set);
	}

}
