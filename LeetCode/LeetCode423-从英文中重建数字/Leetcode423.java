package leetcode;

public class Leetcode423 {
	public String originalDigits(String s) {
		int[] words = new int[26];
		// 先统计一下所有字母的个数
		for (char a : s.toCharArray()) {
			words[a - 'a']++;
		}
		int[] nums = new int[10];
		// 根据每个字符串中唯一出现的字符进行操作
		nums[0] = words['z' - 'a'];			// zero，z在十个字符串的中唯一
		nums[2] = words['w' - 'a'];			// two，w在十个字符串中唯一
		nums[4] = words['u' - 'a'];			// four，u在十个字符串中唯一
		nums[6] = words['x' - 'a'];			// six，x在十个字符串中唯一
		nums[8] = words['g' - 'a'];			// eight，g在十个字符串中唯一
		nums[5] = words['f' - 'a'] - nums[4];	// five中的f，除four外只剩下five，减去four的个数
		nums[7] = words['v' - 'a'] - nums[5];	// seven中的v，
		nums[3] = words['h' - 'a'] - nums[8];	// three中的h，
		nums[9] = words['i' - 'a'] - nums[5] - nums[6] - nums[8];	// nine中的i
		nums[1] = words['o' - 'a'] - nums[0] - nums[2] - nums[4];	// one中的o
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < nums.length; i++) {
			while (nums[i]-- > 0) {
				// 拼接字符串
				str.append(i);
			}
		}
		return str.toString();
	}
}
