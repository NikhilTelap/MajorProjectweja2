package corejava;

public class PracticeStars {

	public static void main(String[] args) {
		
		int i,j;
		int num =6;
		for(i=num;i>=num;i--) {
			
			for(j=1;j<=num-i;j++) {
				System.out.print(" ");
			}
			
			for(j=i;j<=i;j--) {
				System.out.print(j+" ");	
			}
	
	System.out.println();		
	}
	}
}
