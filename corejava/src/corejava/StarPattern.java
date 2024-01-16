package corejava;

public class StarPattern {

	public static void main(String[] args) {
		 
		int i,j;
		int num = 6;
		
		
		
		for(i =1;i<=num;i++) {

			
//to print space and get everything in the middle AND add space in the printing statement==>this one
			
			  for (j = 1; j <= num - i; j++) { 
	                System.out.print(" "); 
	            } 
			  
			  
		for(j=1;j<=i;j++) {
	
//this one 
		System.out.print("* ");
		}
		
		System.out.println();
		}
		
	}
}
