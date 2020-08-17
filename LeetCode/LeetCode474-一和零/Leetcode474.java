package leetcode;

public class Leetcode474 {
	// m个0，n个1 可以看作是背包，而字符串数组strs是物品列表
	// 对于每一个物品(str)，都有放进背包(背包的容量要变成m-zeros,n-ones)和不放进背包两种选择
	// 动态转移方程: dp(i,j,k) = max(dp(i-1,j,k),dp(i-1,j-zeros,k-ones))
	public int findMaxForm(String[] strs, int m, int n) {
		if(strs.length == 0 || (m==0 && n==0)){
	        return 0;
	    }
		// dp数组
		int[][] dp = new int[m + 1][n + 1];
		// 遍历字符数组
		for (String str : strs) {
            int zeros = 0;
            int ones = 0;
            // 处理每个字符，统计1和0的个数
            for (int i = 0; i < str.toCharArray().length; i++) {
                if (str.toCharArray()[i] == '0') {
                    zeros++;
                }else {
                    ones++;
                }
            }
            // 记录每一个dp状态
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - zeros][j - ones]);
                }
            }
        }
		// dp数组最后一个值即为最终答案
        return dp[m][n];
    }	
}
