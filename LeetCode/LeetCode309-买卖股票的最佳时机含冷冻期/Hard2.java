package dp;

public class Hard2 {
	public int maxProfit(int[] prices) {
		int len = prices.length;
		if (len < 2) {		//处理特殊情况
			return 0;
		}
		// dp[i][j] 表示 [0, i] 区间内，到第 i 天（从 0 开始）状态为 j 时的最大收益。
		//j = 0:不持股，j = 1:持股，j = 2:冷冻期
		int[][] dp = new int[len][3];	//用于记录收益
		dp[0][0] = 0;			//第0天不持股：初始化值为0
		dp[0][1] = -prices[0];	//第0天持股：初始化持一股
		dp[0][2] = 0;			//第0天处于冷冻期：初始化值为0
		for (int i = 1; i < len; i++) {
			//不持股状态：1、昨天不持股，今天仍旧如此。2、昨天持股，今天卖了一股
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
			//持股状态：1、昨天持股，今天没卖。2、昨天冷冻，今天买一股
			dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
			//冷冻期状态：昨天卖出一股，今天冷冻
			dp[i][2] = dp[i - 1][1] + prices[i];
		}
		return Math.max(dp[len - 1][0], dp[len - 1][2]);	//输出最后一天的最优解
	}
}
