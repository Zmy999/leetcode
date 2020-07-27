package leetcode;

public class Leetcode392 {
	public boolean isSubsequence(String s, String t) {
		if (s == null || t == null)
			return true;
		int sLen = s.length();
		int index = 0, loc = 0;
		for (int i = 0; i < sLen; i++) {
			// 从第index位置开始查找字符串t中的指定字符
			loc = t.indexOf(s.charAt(i), index);
			if (loc < 0)
				return false;
			// 从下一位置开始遍历
			index = loc + 1;
		}
		return true;
	}
}
