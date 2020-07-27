package leetcode;

public class Leetcode383 {
	public boolean canConstruct(String ransomNote, String magazine) {
		// 因为只包含小写字母，所以用 26 存储空间即可
		int[] arr = new int[26];
		for (int i = 0; i < magazine.length(); i++) {
			// 向 arr 数组中记录每个字符的个数
			arr[magazine.charAt(i) - 'a']++;
		}
		for (int i = 0; i < ransomNote.length(); i++) {
			// 在 arr 数组中对 ransomNote 字符串个数排查减去对应字母后是否 < 0
			if (--arr[ransomNote.charAt(i) - 'a'] < 0) {
				return false;
			}
		}
		return true;
	}
}
