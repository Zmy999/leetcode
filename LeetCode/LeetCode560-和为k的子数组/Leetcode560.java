package leetcode;

public class Leetcode560 {
	// 寻找和为k的连续子数组
	public int subarraySum(int[] nums, int k) {
		int count = 0;
        int len = nums.length;
        for (int left = 0; left < len; left++) {
            int sum = 0;
            // 区间里可能会有一些互相抵销的元素
            for (int right = left; right < len; right++) {
                sum += nums[right];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
