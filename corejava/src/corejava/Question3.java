package corejava;

import java.util.Scanner;

public class Question3 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a sentence");
		String s = scanner.next();
		int count =0;
	
		for(int i=0;i>=s.length();i++) {
			
			if(s.charAt(i)==32) { 
				count++;
			}
			
		}
		System.out.println(count);
		
	}
}
