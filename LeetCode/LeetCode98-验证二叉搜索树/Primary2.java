package tree;

import java.util.Stack;

//中序遍历的顺序正好形成二叉搜索树

public class Primary2 {

	public static boolean isValidBST(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		double inorder = - Double.MAX_VALUE;
		 while (!stack.isEmpty() || root != null) {
		      while (root != null) {
		        stack.push(root);
		        root = root.left;
		      }
		 root = stack.pop();
		 if (root.val <= inorder) 
			 return false;
		 inorder = root.val;
		 root = root.right;
		 }
		 return true;
	}
}
