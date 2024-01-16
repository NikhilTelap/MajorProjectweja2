package corejava;

import java.util.Scanner;

public class Question5 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter age");
		int age = scanner.nextInt();
		System.out.println("Enter sex M/F");
		String gender = scanner.next();
		System.out.println("Enter maritial status");
		String status = scanner.next();
		
		if(gender.charAt(0)=='F' || gender.charAt(0)=='f') {
			System.out.println("Urban areas");
		}
			
		else if(gender.charAt(0)=='m' || gender.charAt(0)=='M' &&( age>20 && age<40)) {
			System.out.println("Work anywhere");
		}
		
		else if(gender.charAt(0)=='m' && age>40 && age<60) {
			System.out.println("urban areas");
		}
		else {
			System.out.println("ERROR");
		}
		

	}
	
	}
