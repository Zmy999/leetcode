package array;

import java.util.Arrays;

public class Primary4 {
	public static boolean containsDuplicate1(int[] nums) {		//暴力解，超时
		for(int i = 0;i < nums.length;i++) {
			for(int j = i + 1;j < nums.length;j++)
				if(nums[j] == nums[i]) {
					return true;
				}	
		}
		return false;
    }
	
	public static boolean containsDuplicate2(int[] nums) {		//先排序，后解
		Arrays.sort(nums);
		for(int i = 0;i < nums.length-1;i++) {
			if (nums[i] == nums[i + 1]) 
				return true;
		}
		return false;
    }
}
