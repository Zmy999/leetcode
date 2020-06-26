package math;

public class Middle4 {
	public static double myPow(double x, int n) {	
		long N = n;
        if (N < 0) {		
            x = 1 / x;		//预先给幂赋值一个-1，继续按快速幂做乘法
            N = -N;
        }
        return fastPow(x, N);
	}
	private static double fastPow(double x, long n) {	//快速幂技巧
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {					//n为偶数
            return half * half;
        } else {							//n为奇数
            return half * half * x;
        }
    }
}
