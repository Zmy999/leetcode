package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Hard1 {

	public static List<List<String>> partition(String s) {	//递归，先判断单字符，再判断双字符
		List<List<String>> res = new ArrayList<>();
		if (s.length() == 0 || s == "")
			return res;
		List<String> list = new ArrayList<>();
		backTracing(res,list, s, 0);
		return res;
	}

	// 递归判定子串并将其加到 res 上
	public static void backTracing(List<List<String>>res,List<String> list, String s, int i) {
		if (i == s.length()) {
			res.add(list);	
		}
		for (int j = i + 1; j <= s.length(); j++) {
			if (isParlindrome(s.substring(i, j))) {		//该子串是回文串
				list.add(s.substring(i, j));			//将该子串添加到list
				backTracing(res,new ArrayList<String>(list), s, j);		//回到上一层
				list.remove(list.size() - 1);			//删除判断过的子串
			}
		}
	}
	
	public static boolean isParlindrome(String s) { 	// 判断是否为回文串
		if (s == "" || s.length() == 0) {
			return false;
		}
		int len = s.length()-1;
		for (int i = 0; i <= len / 2; i++) {
			if (s.charAt(i) != s.charAt(len - i)) {
				return false;
			}
		}
		return true;
	}

}
