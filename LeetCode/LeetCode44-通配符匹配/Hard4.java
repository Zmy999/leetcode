package backtracking;

public class Hard4 {
	public boolean isMatch(String s, String p) {
		int sIdx = 0, pIdx = 0;
		int match = 0, starIdx = -1;
		while (sIdx < s.length()) {
			// 一对一匹配，两指针同时后移
			if (pIdx < p.length() && (p.charAt(pIdx) == '?' || s.charAt(sIdx) == p.charAt(pIdx))) {
				sIdx++;
				pIdx++;
			}
			// 碰到 *，假设它匹配空串，并且用 startIdx 记录 *的位置，记录当前字符串的位置，pIdx后移
			else if (pIdx < p.length() && p.charAt(pIdx) == '*') {
				starIdx = pIdx;
				match = sIdx;
				pIdx++;
			}
			// 当前字符不匹配，并且也没有 *，回退
			else if (starIdx != -1) {
				pIdx = starIdx + 1;		// pIdx回到 * 的下一个位置
				match++;				// match指向s串中的下一个位置
				sIdx = match;			// sIdx指向更新后的 match，在此位置尝试匹配
			}
			// 字符不匹配，也没有 *，返回 false
			else
				return false;
		}
		// 将末尾多余的 * 直接匹配空串 例如 text = ab, pattern = a*******
		while (pIdx < p.length() && p.charAt(pIdx) == '*')
			pIdx++;
		return pIdx == p.length();		//若达到末尾，则匹配成功
	}
}
