package dp;

public class Primary3 {
	public static int maxSubArray1(int[] nums) { // 暴力解法
		int max = Integer.MIN_VALUE;
		if (nums.length < 1 || nums == null)
			return 0;
		int sum;
		for (int i = 0; i < nums.length; i++) {// 子序列左端点
			sum = 0;
			for (int j = i; j < nums.length; j++) {// 子序列右端点
				sum += nums[j];// 这里就相当于每次根据前一次的序列来计算新的序列
				if (sum > max)
					max = sum;
			}
		}
		return max;
	}

	public static int maxSubArray2(int[] nums) { 			// 动态规划
		int current = nums[0];
		int sum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (current < 0)					// 当前数小于0 肯定会舍去（否则将会影响接下来的和）
				current = nums[i]; 				
			else								// 大于0，计入和
				current += nums[i]; 			
			if (current > sum)					//统计最大和
				sum = current;	
		}
		return sum;
	}
}
