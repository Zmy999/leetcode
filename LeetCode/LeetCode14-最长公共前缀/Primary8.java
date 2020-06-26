package string;

public class Primary8 {
	public static String longestCommonPrefix(String[] strs) {
		int index = 0;
		if (strs.length == 0 || strs == null) {								//处理空串
			return "";
		}
	    for(int i = 0;i < strs[0].length();i++) {
	    	char current = strs[0].charAt(index);							//第一个字符串的第一个字符
	    	for (String str : strs) {										//str为当前字符串
	    		if (str.length() == i || current != str.charAt(index)) {	//字符串长度耗尽或遇到不相同字符
                    return str.substring(0, index);							//取0~index长度的子串
                }
	    	}
	    	index++;					//比较每个字符串的第一个字符后，接着比较每个字符串的第二个字符
	    }
	    return strs[0].substring(0, index); 		//如果只有一个字符串，返回该字符串
    }
}
