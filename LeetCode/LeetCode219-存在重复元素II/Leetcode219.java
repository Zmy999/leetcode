package leetcode;

import java.util.HashSet;

public class Leetcode219 {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            // 滑动窗口
            if(set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
