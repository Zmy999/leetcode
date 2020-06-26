package sortandsearch;

import java.util.Arrays;

public class Hard1 {
	public void wiggleSort(int[] nums) {
		Arrays.sort(nums);	
		int[] copy = nums.clone();
		//此处两操作都必须为逆序，否则由于nums中间的元素相等会出错
		int index = 1;				//将copy的右半部分放入nums中以1开始， 间隔为2的位置
		for (int i = nums.length - 1; i > (nums.length - 1) / 2; i--) {
			nums[index] = copy[i];
			index += 2;
		}
		index = 0;					//将copy的左半部分放入nums中以0开始， 间隔为2的位置
		for (int i = (nums.length - 1) / 2; i >= 0; i--) {
			nums[index] = copy[i];
			index += 2;
		}
	}

}
