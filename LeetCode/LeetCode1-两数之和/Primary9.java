package array;

import java.util.Arrays;

public class Primary9 {
	public static int[] twoSum(int[] nums, int target) {
		int num1 = 0,num2 = 0;
		int nums2[] = new int[2];
		for(int i = 0;i < nums.length;i++) {
			for(int j = 0;j < nums.length;j++) {
				if(nums[i] + nums[j] == target && i != j) {
					num1 = i;
					num2 = j;
				}
			}
		}
		nums2[0] = num1;
		nums2[1] = num2;
		return nums2;
    }
}
