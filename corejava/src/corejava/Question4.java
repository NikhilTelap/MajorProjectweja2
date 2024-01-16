package corejava;

import java.util.Iterator;

public class Question4 {

	public static void main(String[] args) {
		
		int i,j;
		int num=7;
		for(i=num;i>=1;i--) {
			
			for(j=1;j<=i;j++) {
			if(j%2==0) {
				System.out.print(0);
			}
			else {
				System.out.print(1);
			}
			}
			System.out.println();
			}
		}
	
}
