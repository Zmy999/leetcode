package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Middle1 {
	public List<String> letterCombinations(String digits) {
		if (digits.length() == 0) {
		    return Collections.EMPTY_LIST;
		}
		Map<Character, String> map = new HashMap<>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		char[] chars = digits.toCharArray();
		List<String> result = new ArrayList<>();				//保存输出结果
		result.add("");
		for (char c : chars) {									//挨个获取数字
			List<String> tmpList = new ArrayList<>();	
			String sufStr = map.get(c);							//获取该数字对应的字符串
			for (String str : result) {
				for (Character tmpC : sufStr.toCharArray()) {	//将该数字对应的字符串拆解
					String tmpStr = str + tmpC;					//拼接字符串
		            tmpList.add(tmpStr);						
				}
			}
			result = tmpList;									//将字符存入result
		}
		return result;
    }
}
