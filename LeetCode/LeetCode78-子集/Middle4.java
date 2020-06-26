package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Middle4 {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();	//保存输出结果
		ans.add(new ArrayList<>());						//空集也为子集
		if (nums == null || nums.length == 0) {
			return ans;
		}
		DFS(ans, new ArrayList<>(), nums, 0);	//从0开始，先取单个元素，再取两个元素...类推
		return ans;
	}

	public void DFS(List<List<Integer>> ans, ArrayList<Integer> list, int nums[], int k) {
		for (int i = k; i < nums.length; i++) {
			list.add(nums[i]);
			ans.add(new ArrayList<>(list));				//java值传递
			DFS(ans, list, nums, i + 1);
			list.remove(list.size()-1);
		}
	}
}
