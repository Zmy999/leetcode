package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode60 {
	public String getPermutation(int n, int k) {
		// 生成nums数组
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
			nums[i] = i + 1;
		// 记录当前的索引的数是否被使用过
		boolean[] used = new boolean[n];
		// 开始递归
		return dfs(nums, new ArrayList<String>(), used, 0, n, k);
	}

	/**
	 * @param nums      原数组
	 * @param levelList 每一层的选择
	 * @param used      数组的元素是否被使用过
	 * @param depth     深度，也就是当前使用的元素的索引
	 * @param n         上限值
	 * @param k         第k个
	 * @return 第k个排列
	 */
	private String dfs(int[] nums, List<String> levelList, boolean[] used, int depth, int n, int k) {
		// 递归出口
		if (depth == n) {
			StringBuilder res = new StringBuilder();
			for (String s : levelList)
				res.append(s);
			return res.toString();
		}
		// 当前的depth也就是索引，有多少排列数
		// depth初始为0，即计算除第一位外剩余n-1位的组合情况
		int cur = factorial(n - depth - 1);
		for (int i = 0; i < n; i++) {
			// 当前元素被使用过，做剪枝
			if (used[i])
				continue;
			// 当前的排列组合数小于k，说明就算这一层排完了，也到不了第k个，剪枝
			if (cur < k) {
				k -= cur;
				continue;
			}
			levelList.add(nums[i] + "");
			// 当前元素被使用过标记
			used[i] = true;
			return dfs(nums, levelList, used, depth + 1, n, k);
		}
		return null;
	}

	// 返回n的阶乘，如3!=3*2*1=6
	private int factorial(int n) {
		int res = 1;
		while (n > 0) {
			res *= n--;
		}
		return res;
	}
}
