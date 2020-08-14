package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode435 {
	public int eraseOverlapIntervals(int[][] intervals) {
		int count = 0;
		// 按照区间右端点升序排序
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[1] - b[1];
			}
		});

		int end = Integer.MIN_VALUE;
		for (int i = 0; i < intervals.length; i++) {
			if (end <= intervals[i][0]) {
				end = intervals[i][1];
				// 不需要移除，count++
				count++;
			}
		}

		return intervals.length - count;
	}
}
