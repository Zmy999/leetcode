package dp;

public class Middle2 {
	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
            	if (i == 0 || j == 0)		//最上和最左，只有一条路径，因为机器人每次只能向下或者向右移动一步
                    dp[i][j] = 1;
            	else {
            		dp[i][j] = dp[i - 1][j] + dp[i][j - 1];//分解路径
            	}
            }
		}
		return dp[m - 1][n - 1];	//最后一个格子即为路径之和
	}
}
