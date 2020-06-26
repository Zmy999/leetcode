package dp;

import java.util.Arrays;

public class Hard3 {

	public int numSquares(int n) {
		// dp[i]:表示第i个数最少需要dp[i]个完全平方数组成。
		int dp[] = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		// 依次求出 1, 2... 直到 n 的解
		for (int i = 1; i <= n; i++) {
			// 依次减去一个平方数
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}
		return dp[n];
	}
}
