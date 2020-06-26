package array;

import java.util.*;

public class Middle1 {
	public List<List<Integer>> threeSum(int[] nums) {
		int len = nums.length;
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(nums);							
		for (int i = 0; i < len; i++) {
			if(nums[i] > 0)							//若第一个元素大于0，则后续一定大于0，故不成立
				break;
			//如果当期的数和前一个数相同，筛选出来的数就和前一个数的结果相同，就会产生重复的数组
			if (i > 0 && nums[i] == nums[i - 1])						
				continue;
			int l = i + 1, r = len - 1;									//左指针，右指针
			while(l < r) {
				int sum = nums[i] + nums[l] + nums[r];
				if(sum == 0) {
					ans.add(Arrays.asList(nums[i],nums[l],nums[r]));//数组转化为List
					while(l < r && nums[l] == nums[l + 1])			   //去重
                        l++;
                    while(l < r && nums[r] == nums[r - 1])				//去重
                        r--;
                    l++;
                    r--;
				}
				else if(sum < 0)
                    l++;
				else
					r--;
			}
		}
		return ans;
	}
}
