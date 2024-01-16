package corejava;

public class PalindromNumber {

	 public static void main(String args[]){  
	
	
		 for(int i=1;i<100;i++) {
		 int num = i;
		 int last;
		 int rev=0;
		 int copy =num;
		 while(num > 0) {
			 last = num % 10;
			 rev = rev*10+last;
			 num = num/10;
			 
		 }
		 
		 if(rev==copy) {
			 System.out.println(copy);
		 }
		 }
	 }	 
	 
	 }  