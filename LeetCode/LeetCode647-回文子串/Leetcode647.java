package leetcode;

public class Leetcode647 {
	public int countSubstrings(String s) {
		// 动态规划法
		boolean[][] dp = new boolean[s.length()][s.length()];
		int ans = 0;
		for (int j = 0; j < s.length(); j++) {
			for (int i = 0; i <= j; i++) {
				// 状态转移方程
				// j-i = 1，单个字符必相等且回文
				// j-i ≥ 2，判断上一结果是否回文，若回文则判断当前左右端点是否相等，相等则回文
				if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
					// 回文，标记为true
					dp[i][j] = true;
					// 结果加一
					ans++;
				}
			}
		}

		return ans;
	}
}
