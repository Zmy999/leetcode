package leetcode;

public class Leetcode338 {
	public int[] countBits(int num) {
		int[] ans = new int[num + 1];
		int k = 0;
		while (k <= num) {
			ans[k] = Integer.bitCount(k);
			k++;
		}
		return ans;
	}
	// 方法二：位运算
	public int[] countBits2(int num) {
		if (num == 0)
			return new int[] { 0 };
		int[] dp = new int[num + 1];
		dp[0] = 0;
		for (int i = 1; i <= num; i++) {
			if (i % 2 == 0)
				dp[i] = dp[i / 2];
			else
				dp[i] = dp[i - 1] + 1;
		}
		return dp;
	}
}
