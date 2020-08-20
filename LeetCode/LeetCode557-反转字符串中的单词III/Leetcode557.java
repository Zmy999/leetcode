package leetcode;

public class Leetcode557 {
	public static void main(String[] args) {
		System.out.println(reverseWords("Let's take LeetCode contest"));
	}
	public static String reverseWords(String s) {
		String[] sp = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= sp.length - 1; i++) {
			StringBuilder t = new StringBuilder();
			t.append(sp[i]);
			sb.append(t.reverse().toString()).append(" ");
		}
		return sb.substring(0, sb.length() - 1);
	}
}
