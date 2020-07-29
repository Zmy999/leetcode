package leetcode;

public class Leetcode397 {
	public int integerReplacement(int n) {
		if (n == Integer.MAX_VALUE)
			return 32;
		if (n <= 3)
			return n - 1;
		// n为偶数
		if (n % 2 == 0)
			return integerReplacement(n / 2) + 1;
		else
			return Math.min(integerReplacement(n + 1), integerReplacement(n - 1)) + 1;
	}
}
