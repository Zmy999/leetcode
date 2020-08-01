package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class Leetcode406 {
	public int[][] reconstructQueue(int[][] people) {
		// 先按H高度降序排序，再按K个数升序排序（注意对二维数组的排序）
		// 两边相等，按照右边数升序，两数不等，按照左边数降序
		// [7,0], [7,1], [6,1], [5,0], [5,2], [4,4]
		Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
		LinkedList<int[]> list = new LinkedList<>();
		for (int[] h : people) {
			//System.out.println(Arrays.toString(h));
			// 按照索引添加
			list.add(h[1], h);
			//System.out.println(h[1]);
		}
		// 格式化输出二维数组
		return list.toArray(new int[list.size()][2]);
	}
}
