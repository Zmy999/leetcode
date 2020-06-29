package leetcode;

import java.util.Arrays;

public class Leetcode16 {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int ans = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < nums.length; i++) {
			int start = i + 1, end = nums.length - 1;
			// 注意此处用while
			while (start < end) {
				int sum = nums[start] + nums[end] + nums[i];
				// 取绝对值
				if (Math.abs(target - sum) < Math.abs(target - ans))
					ans = sum;
				// 判断大小
				if (sum > target)
					end--;
				else if (sum < target)
					start++;
				else
					return ans;
			}
		}
		return ans;
	}
}
