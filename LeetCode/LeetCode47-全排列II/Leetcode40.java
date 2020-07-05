package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Leetcode40 {
	public List<List<Integer>> permuteUnique(int[] nums) {
		int len = nums.length;
		List<List<Integer>> res = new ArrayList<>();
		if (len == 0) {
			return res;
		}
		// 排序是剪枝的前提
		Arrays.sort(nums);
		boolean[] used = new boolean[len];
		// 使用 Deque 是 Java 官方 Stack 类的建议
		Deque<Integer> path = new ArrayDeque<>(len);
		// 开始递归
		dfs(nums, len, 0, used, path, res);
		return res;
	}

	private void dfs(int[] nums, int len, int depth, 
			boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
		// 递归出口
		if (depth == len) {
			res.add(new ArrayList<>(path));
			return;
		}
		for (int i = 0; i < len; ++i) {
			// 已经使用过，直接下一个
			if (used[i]) {
				continue;
			}
			// 剪枝
			// i > 0 是为了保证 nums[i - 1] 有意义
			// 写 used[i - 1] == false 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
			if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
				continue;
			}
			path.addLast(nums[i]);
			used[i] = true;
			dfs(nums, len, depth + 1, used, path, res);
			// 回溯部分的代码，和 dfs 之前的代码是对称的
			used[i] = false;
			// 清空上一步添加的集合
			path.removeLast();
		}
	}

}
