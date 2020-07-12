package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode90 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		// 排序
		Arrays.sort(nums); 
		dfs(nums, 0, new ArrayList<>(), ans);
		return ans;
	}

	private void dfs(int[] nums, int start, ArrayList<Integer> temp, List<List<Integer>> ans) {
		// 第一次递归添加空集，其后不断添加结果集
		ans.add(new ArrayList<>(temp));
		for (int i = start; i < nums.length; i++) {
			// 和上个数字相等就跳过
			if (i > start && nums[i] == nums[i - 1]) {
				continue;
			}
			temp.add(nums[i]);
			dfs(nums, i + 1, temp, ans);
			// 回头
			temp.remove(temp.size() - 1);
		}
	}

}
