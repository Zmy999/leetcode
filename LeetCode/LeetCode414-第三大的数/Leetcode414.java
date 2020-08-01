package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Leetcode414 {
	public int thirdMax(int[] nums) {
		Arrays.sort(nums);
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			// 去重
			if (!list.contains(nums[i])) {
				list.add(nums[i]);
			}
		}
		if (list.size() < 3) {
			return list.get(list.size() - 1);
		}
		return list.get(list.size() - 3);
	}
}
