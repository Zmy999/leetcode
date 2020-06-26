package math;

public class Middle2 {
	public static int trailingZeroes(int n) {	//有几个5，就有几个零
		int count = 0;
		while(n != 0){
			count += n/5;
			n /= 5;
		}
		return count;
    }
	public static void main(String[] args) {
		int n = 6;
		System.out.println(trailingZeroes(n));
	}
}
