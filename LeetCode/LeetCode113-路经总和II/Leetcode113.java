package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode113 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> tmp = new ArrayList<>();
		// 递归求解路径总和
		dfs(root, sum, ans, tmp);
		return ans;
	}
	private void dfs(TreeNode root, int sum, List<List<Integer>> ans, List<Integer> tmp) {
		if (root == null) {
			return;
		}
		tmp.add(root.val);
		// 如果只有根节点或只有叶子结点，则直接放入 ans 中
		if (root.left == null && root.right == null && sum == root.val) {
			ans.add(new ArrayList<>(tmp));
		}
		dfs(root.left, sum - root.val, ans, tmp);
		dfs(root.right, sum - root.val, ans, tmp);
		// 回头
		tmp.remove(tmp.size() - 1);
	}
}
