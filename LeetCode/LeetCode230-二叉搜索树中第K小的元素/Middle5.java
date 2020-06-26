package tree;

public class Middle5 {
	private int count = 1;
	private int res;
	public int kthSmallest(TreeNode root, int k) {
		inorder(root, k);
		return res;
	}
	//通过构造 BST 的中序遍历序列，则第 k-1 下标的元素就是第 k 小的元素。
	public void inorder(TreeNode root, int k) {	
		if (root == null)
			return;
		inorder(root.left, k);			//左
		if (count++ == k) {				//中
			res = root.val;
			return;
		}
		inorder(root.right, k);			//右
	}
}
