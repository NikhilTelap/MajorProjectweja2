package corejava;

public class Question7 {

	public static void main(String[] args) {
		
		int num = 5555;
		int sum=0;
		int r=0;
		
		while(num>0) {
			
			r = num%10;
			sum = sum+r;
			num = num/10;
		}
		System.out.println(sum);
		
	}
}
