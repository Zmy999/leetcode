package dp;

public class Hard1 {
	public static void main(String[] args) {
		int nums[] = { 2, 3, -2, 4 };
		System.out.println(maxProduct(nums));
	}

	// 请你找出数组中乘积最大的连续子数组
	public static int maxProduct(int[] nums) {
		int max = Integer.MIN_VALUE, cMax = 1, cMin = 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) { 	// 出现负数则交换最大最小值，考虑偶数个负数的情况
				int temp;
				temp = cMax;
				cMax = cMin;
				cMin = temp;
			}
			//分别判断取当前位置的值和当前位置乘积累计的值进行比较
			cMax = Math.max(nums[i], cMax * nums[i]);
			cMin = Math.min(nums[i], cMin * nums[i]);
			max = Math.max(max, cMax);
		}
		return max;
	}
}
