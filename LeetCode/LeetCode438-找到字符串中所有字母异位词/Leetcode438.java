package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode438 {
	// 滑动窗口
	// 从s的第一个位置开始，以p的长度作为窗口，从左到右遍历截取s
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> resList = new ArrayList<Integer>();
		if (s == null || s.length() == 0 || s.length() < p.length())
			return resList;

		char[] pChar = p.toCharArray();
		Arrays.sort(pChar);
		int pLen = p.length();
		for (int i = 0; i < s.length() - pLen + 1; i++) {
			// 截取长度为pLen的字符串
			String curr = s.substring(i, i + pLen);
			char[] currChar = curr.toCharArray();
			Arrays.sort(currChar);
			// 排序后进行比较，若相同则添加当前字符串位置
			if (Arrays.equals(pChar, currChar)) {
				resList.add(i);
			}
		}
		return resList;
	}
}
