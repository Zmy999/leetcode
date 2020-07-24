package leetcode;

public class Leetcode236 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q)
			return root;
		// 查左子树
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		// 查右子树
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		// 左为空，返回右子树进行遍历
		if (left == null)
			return right;
		if (right == null)
			return left;
		return root;
	}
}
