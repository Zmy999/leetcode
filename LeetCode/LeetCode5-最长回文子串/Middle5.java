package array;

public class Middle5 {
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		int strLen = s.length();
		int left = 0, right = 0;
		int len = 1; 							// 窗口大小
		int maxStart = 0; 						// 最长回文串时的起始位置
		int maxLen = 0; 						// 最长回文长度
		for (int i = 0; i < strLen; i++) { 		// 处理三种情况
			left = i - 1;
			right = i + 1;
			while (left >= 0 && s.charAt(left) == s.charAt(i)) {	//当前回文长度为奇数，且中心与左边相等
				len++;
				left--;
			}
			while (right < strLen && s.charAt(right) == s.charAt(i)) {	//当前回文长度为奇数，且中心与右边相等
				len++;
				right++;
			}
			while (left >= 0 && right < strLen && s.charAt(right) == s.charAt(left)) {	//回文长度为奇数且，左与右相等
				len = len + 2;		//窗口+2
				left--;
				right++;
			}
			if(len > maxLen) {		//保留当前最大值
				maxLen = len;
				maxStart = left;
			}
			len = 1;				//对每个位置i进行一次判断，len重置
		}
		return s.substring(maxStart + 1, maxStart + maxLen + 1);	//返回字串索引从0开始，故需要+1
	}
}
