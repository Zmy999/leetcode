package leetcode;

import java.util.Arrays;

public class Leetcode416 {
	public boolean find(int[] nums, int target, int index) {
		if (target == 0)
			return true;
		for (int i = index; i < nums.length; i++) {
			if (i > index && nums[i] == nums[i - 1])
				continue;
			if (target - nums[i] < 0)
				return false;
			if (find(nums, target - nums[i], i + 1))
				return true;
		}
		return false;
	}

	public boolean canPartition(int[] nums) {
		int total = 0;
		for (int num : nums)
			total += num;
		Arrays.sort(nums);
		// 如果不是偶数则一定不满足题意
		if (total % 2 != 0)
			return false;
		if (total == 0)
			return true;
		return find(nums, total / 2, 0);
	}
}
