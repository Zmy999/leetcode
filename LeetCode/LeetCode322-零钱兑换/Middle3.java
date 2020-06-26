package dp;

import java.util.Arrays;

public class Middle3 {
	public int coinChange(int[] coins, int amount) {
		if (coins == null || coins.length == 0 || amount == 0) {
			return 0;
		}
		int[] dp = new int[amount + 1]; 		// dp[amount]即为组合价格为aomount所需的硬币个数
		Arrays.fill(dp, amount + 1); 			// 预先对不可能凑出来的值赋给他一个最大值
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {				//存储每个位置的最优解
				if (i >= coin) {
					dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
				}
			}
		}
		return dp[amount] == amount + 1 ? -1 : dp[amount];		//处理
	}
}
