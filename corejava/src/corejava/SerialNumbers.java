package corejava;

public class SerialNumbers {

	
	public static void main(String[] args) {
		int i,j;
		int num =5;
		
		for(i=num;i>=1;i--) {
		
			for(j=1;j<=num-i;j++) {
				System.out.print(" ");
			}
		for(j=1;j<=num;j++) {
			System.out.print(" *");
		}
		System.out.println(" ");
		}
	}
}