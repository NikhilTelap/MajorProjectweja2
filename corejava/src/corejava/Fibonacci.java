package corejava;

public class Fibonacci {
	public static void main(String[] args) {
		
		int num=12;
		int prev=0;
		int next = 1;
		
//		System.out.print(prev+" "+next);
		for(int i=0;i<num;i++) {
			int sum = prev+next;
			prev = next;
			next = sum;
			System.out.print(" "+sum+" ");

		}

	}

}
