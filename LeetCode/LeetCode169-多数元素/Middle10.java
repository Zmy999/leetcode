package math;

import java.util.HashMap;
import java.util.Map;

public class Middle10 {
	public static int majorityElement(int[] nums) {
		int num = 0;
		int n = nums.length; // n为数组大小
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (!map.containsKey(nums[i]))
				map.put(nums[i], 1);
			else
				map.put(nums[i], map.get(nums[i]) + 1);
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > n / 2)
				num = entry.getKey();
		}
		return num;
	}
}
