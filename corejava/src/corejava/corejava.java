package corejava;

import java.util.Scanner;

public class corejava {
	
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter p");
		int p = scanner.nextInt();
		
		System.out.println("Enter r");
		int r = scanner.nextInt();

		
		System.out.println("Enter t in months");
		int t = scanner.nextInt();

		System.out.println(p*r*t/100);
		
	}
	

}
