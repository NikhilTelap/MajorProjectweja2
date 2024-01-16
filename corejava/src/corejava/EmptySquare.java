package corejava;

public class EmptySquare {

	
	public static void main(String[] args) {
		 
		int i,j;
		int num = 6;
		
		for(i =0;i<num;i++) {
	
			for(j =0;j<num;j++) {
				
				if(i==0 || j==0 || j==num-1 || i==num-1) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
				System.out.println();
			
		}
	}
}
