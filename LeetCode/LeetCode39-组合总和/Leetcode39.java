package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode39 {
	List<List<Integer>> ans = new ArrayList<>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if (candidates == null || candidates.length == 0 || target < 0) {
			return ans;
		}
		List<Integer> temp = new ArrayList<>();
		dfs(0, candidates, target, temp);
		return ans;
	}

	private void dfs(int start, int[] candidates, int target, List<Integer> temp) {
		// 递归的终止条件
		if (target < 0) {
			return;
		}
		if (target == 0) {
			ans.add(new ArrayList<>(temp));
		} else {
			for (int i = start; i < candidates.length; i++) {
				temp.add(candidates[i]);
				// 因为每个数字都可以使用无数次，所以递归还可以从当前元素开始
				dfs(i, candidates, target - candidates[i], temp);
				temp.remove(temp.size() - 1);
			}
		}
	}
}
