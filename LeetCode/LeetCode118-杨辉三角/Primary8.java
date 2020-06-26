package math;

import java.util.ArrayList;
import java.util.List;

public class Primary8 {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < numRows; i++) {
			ArrayList<Integer> sub = new ArrayList<Integer>();
			for (int j = 0; j <= i; j++) {
				// 第一个位置和最后一个位置的元素为1
				if (j == 0 || j == i) {
					sub.add(1);
				} else {
					// 上一行(i-1)的两个相邻元素进行相加
					sub.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
				}
			}
			// 保存该行结果
			result.add(sub);
		}
		return result;
	}
}
