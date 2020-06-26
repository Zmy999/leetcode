package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Hard6 {
	public int longestConsecutive(int[] nums) {
		int longestStreak = 1;
        int currentStreak = 1;
		if (nums.length == 0) {
            return 0;
        }
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i-1]) {				//当前数字和前一个数字不相等
				if (nums[i] == nums[i-1]+1) {		//检查当前数字是否能延长答案序列
                    currentStreak += 1;
                }
				else {								//否则记录中断，当前序列长度重置
                    longestStreak = Math.max(longestStreak, currentStreak);	
                    currentStreak = 1;				
                }	
			}
		}
		return Math.max(longestStreak, currentStreak);	//考虑最后一个数字的情况
    }
	
	public int longestConsecutive2(int[] nums) {	//超时
        int count = 0;
		int max = 0;
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0;i < nums.length;i++) {
			map.put(nums[i], 1);
		}
		for(int i = Integer.MIN_VALUE;i <= Integer.MAX_VALUE;i++) {		//此处超时
			if(map.containsKey(i)) 
				count++;
			else if(!map.containsKey(i))
				count = 0;
			if(count > max)
				max = count;
		}
		return max;
    }
	
	
	
}
