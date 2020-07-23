package leetcode;

public class Leetcode226 {
	// 递归遍历每个节点，将左右子树进行交换即可
	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;
		TreeNode tmp = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(tmp);
		return root;
	}
}
