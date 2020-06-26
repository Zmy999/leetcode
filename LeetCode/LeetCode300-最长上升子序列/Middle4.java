package dp;

import java.util.Arrays;

public class Middle4 {
	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
	    Arrays.fill(dp, 1);		// dp 数组全都初始化为 1
	    //定义 dp[i] 为考虑前 i 个元素，以第 i 个数字结尾的最长上升子序列的长度，注意 nums[i] 必须被选取
	    for (int i = 0; i < nums.length; i++) {
	        for (int j = 0; j < i; j++) {
	        	if(nums[i] > nums[j])
	        		dp[i] = Math.max(dp[i], dp[j] + 1);		//预先截取一段，在这段里不断向前找满足题意的字段
	        }
	    }
	    int res = 0;
	    for (int i = 0; i < dp.length; i++) {
	        res = Math.max(res, dp[i]);				//取最长上升序列
	    }
	    return res;
    }
}
