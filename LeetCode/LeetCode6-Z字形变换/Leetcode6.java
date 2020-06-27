package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode6 {
	public String convert(String s, int numRows) {
		if (numRows < 2)
			return s;
		List<StringBuilder> rows = new ArrayList<StringBuilder>();
		// 开numRows行的数组
		for (int i = 0; i < numRows; i++)
			rows.add(new StringBuilder());
		int i = 0, flag = -1;
		for (char c : s.toCharArray()) {
			rows.get(i).append(c);
			if (i == 0 || i == numRows - 1)
				flag = -flag;
			i += flag;
		}
		// 最终结果，将各行拼接
		StringBuilder res = new StringBuilder();
		for (StringBuilder row : rows)
			res.append(row);
		return res.toString();
	}
}
