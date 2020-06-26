package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Hard5 {
	
	public static void main(String[] args) {
		String s = "catsanddog";
		List<String> wordDict = new ArrayList<>();
		//wordDict.add("catsanddog");
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		System.out.println(wordBreak(s,wordDict));
	}
	
	public static List<String> wordBreak(String s, List<String> wordDict) {
	    HashSet<String> set = new HashSet<>();
	    for (int i = 0; i < wordDict.size(); i++) {
	        set.add(wordDict.get(i));				//将字典中的每个字符串添加到set集合里
	    }
	    return wordBreakHelper(s, set, new HashMap<String, List<String>>());
	}

	private static List<String> wordBreakHelper(String s, 
				HashSet<String> set, HashMap<String, List<String>> map) {
	    if (s.length() == 0) {
	        return new ArrayList<>();	//返回空集合
	    }
	    if (map.containsKey(s)) {		//判断是否包含键=s的键值对
	        return map.get(s);			//获得键=s的键值对
	    }
	    List<String> res = new ArrayList<>();	//结果集
	    for (int j = 0; j < s.length(); j++) {
	        //判断当前字符串是否存在，从后截取
	        if (set.contains(s.substring(j, s.length()))) {
	        	//查看System.out.println(s.substring(j, s.length()));
	            // wordDict字典里只有一个字符串和s相同
	            if (j == 0) {
	                res.add(s.substring(j, s.length()));
	            } 
	            // 多个字符串
	            else {
	                //递归得到剩余字符串的所有组成可能，然后和当前字符串分别用空格连起来加到结果中
	            	//截取剩余的字符串左开右闭
	            	//查看System.out.println(s.substring(0, j));
	                List<String> temp = wordBreakHelper(s.substring(0, j), set, map);
	                for (int k = 0; k < temp.size(); k++) {
	                    String t = temp.get(k);
	                    //从后往前拼接
	                    res.add(t + " " + s.substring(j, s.length()));
	                }
	            }

	        }
	    }
	    //缓存当前结果
	    //查看System.out.println(res);
	    map.put(s, res);
	    //查看System.out.println(map);
	    return res;
	}
}
