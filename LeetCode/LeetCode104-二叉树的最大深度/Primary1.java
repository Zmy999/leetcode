package tree;
import tree.TreeNode;

public class Primary1 {
	public static int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		else {
			int left_height = maxDepth(root.left);
			int right_height = maxDepth(root.right);
			return Math.max(left_height, right_height) + 1;
		}
    }
}
