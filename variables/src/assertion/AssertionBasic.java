package assertion;

public class AssertionBasic {
	public static void main(String[] args) {
		int res = sum(2,4);
		 assert res==(1+4):"Number does not correspond";
	}
	
	private static int sum(int x,int y){
		return x+y;
	}
	
	
	
}
