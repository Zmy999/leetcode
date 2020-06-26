package string;

public class Primary7 {
	public static int strStr(String haystack, String needle) {
		int l1=haystack.length(),l2=needle.length();
		if(l1 < l2) {			//此种情况不可能包含子串
			return -1;
		}
		else if(l2 == 0) {		//空串则返回0
			return 0;
		}
		int threshold=l1-l2;
		for(int i = 0; i <= threshold;i++) {
			//在haystack中取l2长度的字符，判断是否等于needle
            if(haystack.substring(i,i+l2).equals(needle)) {
                return i;
            }
        }
		return -1;
    }

}
