package leetcode;

import java.util.HashMap;

public class Leetcode409 {
	public int longestPalindrome(String s) {
		int n = s.length();
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			// getOrDefault：map中若存在键=c的值，则返回该值，否则返回默认值0
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int res = 0;
		for (Character key : map.keySet()) {
			int val = map.get(key);
			// 如果是奇数，则-1变为偶数后加入
			if (val % 2 != 0)
				res += (val - 1);
			// 如果为偶数，则直接加入
			else
				res += val;
		}
		// 没加完，说明有奇数，则加1放在中间即可
		if (res < n)
			return res + 1;
		else
			return res;
	}
}
