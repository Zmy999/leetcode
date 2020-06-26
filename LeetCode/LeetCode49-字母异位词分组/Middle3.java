package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Middle3 {
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		Map<String, List<String>> m = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			char[] r = strs[i].toCharArray();			
			Arrays.sort(r);							//打乱后重新排序
			String k = new String(r);				//生成新的字符串
			if (m.containsKey(k)) {					//哈希中包含该值，则字母构成相同，放入同一组
				List<String> p = m.get(k);
				p.add(strs[i]);						//将该异位词放入List
				m.put(k, p);
			} else {								//哈希中不包括该值，则字母构成不同，新开一组
				List<String> p = new ArrayList<>();
				p.add(strs[i]);
				m.put(k, p);
			}
		}
		res.addAll(m.values());						//全部放入res中
		return res;
	}

	public static void main(String[] args) {
		String strs[] = { "eat", "tea", "tan", "ate", "nat", "bat" };
		System.out.println(groupAnagrams(strs));
	}
}
