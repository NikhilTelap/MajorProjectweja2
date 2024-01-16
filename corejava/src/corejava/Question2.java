package corejava;

import java.util.Scanner;

public class Question2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter three numbers");
		int a=scanner.nextInt();
		int b=scanner.nextInt();
		int c = scanner.nextInt();
		
		maximum(a, b, c);
		minimum(a, b, c);
		
		
	}
	
	public static void maximum(int a,int b,int c) {
		if(a>b && a>c) {
			System.out.println(a+"is the greater number");
		}
		else if(b>c && b>a) {
			System.out.println(b+" is greater number");
		}
		else if(c>a && c>a) {
			System.out.println(c +"is a greater number");
		}
		
		
	}
	
	
	public static void minimum(int a,int b,int c) {
		if(a<b && a<c) {
			System.out.println(a+"is the smaller number");
		}
		else if(b<c && b<a) {
			System.out.println(b+" is smaller number");
		}
		else if(c<a && c<a) {
			System.out.println(c +"is a smaller number");
		}
		
		
	}
}
