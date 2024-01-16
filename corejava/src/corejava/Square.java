package corejava;

public class Square {

	public static void main(String[] args) {
		
		int num= 5;
		int sq = 3;
		int res = 1;
		for(int i=1;i<=sq;i++) {
			res = res*num;
		}
		System.out.println(res);
	}
}
