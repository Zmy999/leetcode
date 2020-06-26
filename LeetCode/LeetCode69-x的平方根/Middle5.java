package math;

public class Middle5 {
	public static int mySqrt(int x) {
		if (x == 0 || x == 1) {
			return x;
		}
		for (long i = 1; i < x; i++) {
			if (i * i == x)
				return (int) i;
			if (i * i > x)
				return (int) i - 1;
		}
		return 1;
	}
}
