package dp;

import java.util.List;

public class Hard4 {
	public boolean wordBreak(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 0; i <= s.length(); i++) {
			for (int j = 0; j != i; j++) {
				if (wordDict.contains(s.substring(j, i)) && dp[j]) {
					dp[i] = true;	//此时的i已执行了++操作，即为下一个元素
					break;
				}
			}
		}
		return dp[s.length()];
	}
}
