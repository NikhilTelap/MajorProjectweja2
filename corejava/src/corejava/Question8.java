package corejava;

public class Question8 {

	public static void main(String[] args) {
		
		String s  ="nikhil";
		String sCopy=s;
		String rev = "";
		
		for(int i=s.length()-1;i>=0;i--) {
			rev = rev+s.charAt(i);
		}
		
		if(rev.equals(sCopy)) {
			System.out.println("Its a palindrom string");
		}
		
		else {
			System.out.println("Its not a palindrom string");
		}
		
    System.out.println(rev);
	}
	

	}
