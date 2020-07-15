package leetcode;

public class Leetcode67 {
	public String addBinary(String a, String b) {
		StringBuilder ans = new StringBuilder();
		// 进位标志位
		int ca = 0;
		// 从后向前遍历
		for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
			int sum = ca;
			sum += i >= 0 ? a.charAt(i) - '0' : 0;
			sum += j >= 0 ? b.charAt(j) - '0' : 0;
			// 如果二者都为1  那么sum%2应该刚好为0 否则为1
			ans.append(sum % 2);
			// 如果二者都为1  那么ca 应该刚好为1 否则为0
			ca = sum / 2;
		}
		// 判断最后一次计算是否有进位  有则在最前面加上1 否则原样输出
		ans.append(ca == 1 ? ca : "");
		return ans.reverse().toString();
	}
}
