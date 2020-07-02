package leetcode;

import java.util.Arrays;

public class Leetcode31 {
	public void nextPermutation(int[] nums) {
		if (nums == null)
			return;
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1]) {
				Arrays.sort(nums, i, nums.length);
				for (int j = i; j < nums.length; j++) {
					if (nums[i - 1] < nums[j]) {
						int temp = nums[j];
						nums[j] = nums[i - 1];
						nums[i - 1] = temp;
						return;
					}
				}
			}
			if (i == 1) {
				Arrays.sort(nums);
				return;
			}
		}
	}
}
