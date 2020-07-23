package leetcode;

public class Leetcode209 {
	public int minSubArrayLen(int s, int[] nums) {
		// min为下标字符串长度
		int low = 0, high = 0, sum = 0, min = Integer.MAX_VALUE;
		while (high < nums.length) {
			// 右指针右移
			sum += nums[high++];
			while (sum >= s) {
				// 比较，取较小值
				min = Math.min(min, high - low);
				// 指针左指针右移
				sum -= nums[low++];
			}
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}
}
