package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode442 {
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> ans = new ArrayList<Integer>();
		Arrays.sort(nums);
		int p = 0,q = 1;
		while(q < nums.length && p < nums.length) {
			if(nums[p] == nums[q]) {
				ans.add(nums[q]);
				p++;
				q++;
			}
			else {
				p++;
				q++;
			}
		}
		return ans;
    }
}
