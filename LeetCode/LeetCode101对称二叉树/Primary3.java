package tree;

public class Primary3 {
	 public static boolean isSymmetric(TreeNode root) {
		 if (root == null) {
	            return true;
	        }
		 else {
			 return isSymmetric(root.left, root.right);
		 }
	 }
	 
	 private static boolean isSymmetric(TreeNode left_Node, TreeNode right_Node) {
		 if (left_Node == null && right_Node == null) {
	            return true;
	        }
		 else if (left_Node == null || right_Node == null) {
	            return false;
	        }
		 return left_Node.val == right_Node.val && isSymmetric(left_Node.left, right_Node.right) && isSymmetric(left_Node.right, right_Node.left);
	 }
}
