package array;

import java.util.HashMap;
import java.util.Map;

public class Hard5 {
	public static void main(String[] args) {
		int nums[] = {3,4,-1,1};
		System.out.println(firstMissingPositive(nums));
	}
	public static int firstMissingPositive(int[] nums) {
		int ans = 0;
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0;i < nums.length;i++) {
			map.put(nums[i], 1);
		}
		for(int i = 1;i <= Integer.MAX_VALUE;i++) {
			if(!map.containsKey(i)) {
				ans = i;
				break;
			}
		}
		return ans;
    }
}
