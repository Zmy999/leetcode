package leetcode;

public class Leetcode205 {
	public boolean isIsomorphic(String s, String t) {
	    return isIsomorphicHelper(s).equals(isIsomorphicHelper(t));
	}

	private String isIsomorphicHelper(String s) {
	    int[] map = new int[128];
	    int n = s.length();
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < n; i++) {
	        char c = s.charAt(i);
	        //当前字母第一次出现,赋值
	        if (map[c] == 0) {
	            map[c] = i + 1;
	        }
	        // 拼接字符
	        sb.append(map[c]);
	    }
	    return sb.toString();
	}
}
