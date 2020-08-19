package leetcode;

public class Leetcode538 {
	int sum = 0; // 记录当前值
	public TreeNode convertBST(TreeNode root) {
		convertMiddleOrderTraversal(root);
		return root;
	}

	public void convertMiddleOrderTraversal(TreeNode root) {
		if (root == null) { // 递归出口，空树终止
			return;
		}
		convertMiddleOrderTraversal(root.right); // 先访问右子树
		/* 对根节点做的改变 */
		sum += root.val;
		root.val = sum;
		convertMiddleOrderTraversal(root.left); // 在访问左子树
	}
}
