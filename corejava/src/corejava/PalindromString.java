package corejava;

public class PalindromString {

	
	public static void main(String[] args) {
		
		
		String s = "malayalam";
		String copy="";
		for(int i=s.length()-1;i>=0;i--) {
			copy=copy+s.charAt(i);
		}
		if(s.equals(copy)) {
			System.out.println("palindrom");
		}
		else {
			System.out.println("not palindrom");
		}
	
		
	}
}
