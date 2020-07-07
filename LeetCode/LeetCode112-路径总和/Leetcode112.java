package leetcode;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Leetcode112 {
	public boolean hasPathSum(TreeNode root, int sum) {
		return helper(root, 0, sum);
	}

	public boolean helper(TreeNode root, int cur, int sum) {
		if (root == null)
			return false;
		cur = cur + root.val;
		// 设置递归出口
		if (root.left == null && root.right == null) {
			return cur == sum;
		} else {
			return helper(root.left, cur, sum) || helper(root.right, cur, sum);
		}
	}
}
