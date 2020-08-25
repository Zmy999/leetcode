package leetcode;

public class Leetcode543 {
	// 二叉树直径实际上就是二叉树中的最长路径
	// 二叉树的最长路径 = max{左子树的最长路径,右子树的最长路径,经过根结点的最长路径}
	int maxDiameter = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		getDepth(root);
		return maxDiameter;
	}

	private int getDepth(TreeNode t) {
		if (t == null)
			return 0;
		// 计算左子树的最长路径
		int lDepth = getDepth(t.left);
		// 计算右子树的最长路径
		int rDepth = getDepth(t.right);
		// 比较当前最大值和全局路径
		maxDiameter = Math.max(lDepth + rDepth, maxDiameter);
		// 取当前的最长路径
		return Math.max(lDepth, rDepth) + 1;
	}
}
