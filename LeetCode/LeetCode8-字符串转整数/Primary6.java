package string;

public class Primary6 {
	public static int myAtoi(String str) {
		str = str.trim();		// 去空格
		if (str == " " || str.length() == 0 || str == null) {		// 判断不为空
			return 0;
		}
		char c = str.charAt(0);
		if ((c > '9' || c < '0') && c != '+' && c != '-') {		// 判断首字母必须是0-9 或 + -
			return 0;
		}
		StringBuilder sb = new StringBuilder();
		char[] chars = str.toCharArray();
		sb.append(chars[0]);									// 将第一个字符加入buffer
		for (int i = 1; i < chars.length; i++) {
			if (chars[i] < '0' || chars[i] > '9') {				// 遇到非数字则退出循环
				break;
			}
			sb.append(chars[i]);
		}
		// 如果只有一个+号 或者只有一个-号则说明不含数字，返回0
		if (sb.length() == 1 && (sb.charAt(0) == '+' || sb.charAt(0) == '-')) {
			return 0;
		}
		// 尝试转换成数字，如果失败了，则说明超过Integer 得取值范围，则返回最大值或最小值
		try {
			return Integer.valueOf(sb.toString());
		} catch (Exception e) {
			return sb.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		}
	}
}
