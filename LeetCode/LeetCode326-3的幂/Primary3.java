package math;

public class Primary3 {
	public static boolean isPowerOfThree(int n) {
		if(n < 1)
			return false;
		while(n % 3 == 0) {
			n = n/3;
		}
		return n == 1;
    }
	
	public static void main(String[] args) {
		System.out.println(isPowerOfThree(45));
	}
}
