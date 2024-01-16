package corejava;

public class MiddleCount {

	public static void main(String[] args) {
		
		int i,j;
		int num =6;
		
		for(i=1;i<=num;i++) {
			
			
			
			//To take anything in the middle
			for (j = 1; j <= num - i; j++) { 
                System.out.print(" "); 
            } 

			
			for(j=1;j<=i;j++) {
				System.out.print(i+" ");
			}
			
			System.out.println();
		}
	}
}
