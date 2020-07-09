package leetcode;

import java.util.List;

public class Leetcode120 {
	public int minimumTotal(List<List<Integer>> triangle) {
		// 特判
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}
		// 行
		int row = triangle.size();
		// 列（取最后一行的列数即得总列数）
		int column = triangle.get(row - 1).size();

		int[][] dp = new int[row][column];
		dp[0][0] = triangle.get(0).get(0);
		int res = Integer.MAX_VALUE;

		// 对每一行的元素进行推导
		for (int i = 1; i < row; i++) {
			for (int j = 0; j <= i; j++) {
				// 最左端特殊处理
				if (j == 0) {
					dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);	
				} 
				// 最右端特殊处理
				else if (j == i) {
					dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
				} 
				else {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
				}
			}
		}
		// dp最后一行记录了最小路径
		for (int i = 0; i < column; i++) {
			res = Math.min(res, dp[row - 1][i]);
		}
		return res;
	}
}
