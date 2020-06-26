package string;

public class Primary5 {
	public static boolean isPalindrome(String s) {
		char[] chars = s.toCharArray();
		int cnt = 0;
		int j = 0;
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {		//过滤字符串，选择字母，数字
				chars[cnt++] = c;
			} else if (c >= 'A' && c <= 'Z') {							//大写转小写
				chars[cnt++] = (char) (c - 'A' + 'a');
			}
		}
		cnt--;															//多加了一次，返回数组下标应该减1
		while (cnt > j) {
			if (chars[cnt--] != chars[j++]) {
				return false;
			}
		}
		return true;
	}
}
