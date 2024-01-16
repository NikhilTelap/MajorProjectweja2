package corejava;


public class ArmstringNum {

	public static void main(String[] args) {
		
		;
		
		for(int i=1;i<1000;i++) {
			int num = i;
			int last ;
			int copy = num;
			int add = 0;
		
		while(num >0)  {
			
			last = num %10;
			last = last*last*last;
			add = add+last;
			num = num/10;
		}
		if(copy==add) {
			System.out.print(copy+" ");
		}
			}
		}
	}
	
