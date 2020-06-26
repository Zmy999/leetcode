package array;

import java.util.Arrays;

public class Primary3 {
	public static void rotate1(int[] nums, int k) {		//双循环
		int len = nums.length;
		for(int i = 0;i < k;i++) {
			int temp = nums[len-1];				//取最后一个
			for(int j = len-1;j >0;j--) {
				nums[j] = nums[j-1];			//右移
			}
			nums[0] = temp;						//将最后一个提到第一个
		}
		System.out.println(Arrays.toString(nums));
    }
	
	public static void rotate2(int[] nums, int k) {		//开数组
		int nums2[] = new int[nums.length];
		for(int i =0;i < nums.length;i++) {
			if(i < nums.length-k)				//将前i个元素放到新数组的后i个位置
				nums2[i+k] = nums[i];
			else {								//将后i个元素放到新数组的前m个位置
				int m = (i+k)%nums.length;
				nums2[m] = nums[i];
			}
		}
		System.out.println(Arrays.toString(nums2));
    }	
}
