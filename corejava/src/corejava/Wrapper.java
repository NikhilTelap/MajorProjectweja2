package corejava;

public class Wrapper {

	
	public static void main(String[] args) {
		Wrapper.wrapperType(10, 20);
	}
	
	public static void wrapperType(Integer a, Integer b) {
		int c = a+b;
		System.out.println("sum"+c);
	}
	
	public static void wrapperType(int a, int b) {
		int c = a+b;
		System.out.println("sum is :"+c);
	}

}
