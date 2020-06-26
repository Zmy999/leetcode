package tree;

import java.util.Arrays;

public class Middle3 {

	private static int find(int[] array, int v) {		//查找特定点位置
		for (int i = 0; i < array.length; i++) {
			if (array[i] == v) {
				return i;
			}
		}
		return -1;
	}
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0) {
			return null;
		}
		int rootValue = preorder[0]; 					// 根据前序，找到根的值，并且创建根节点
		TreeNode root = new TreeNode(rootValue);
		int leftSize = find(inorder, rootValue); 		// 在中序中找到根的值所在的下标
		// 切出左子树的前序和中序
		int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + leftSize);		//0为根
		int[] leftInorder = Arrays.copyOfRange(inorder, 0, leftSize);
		root.left = buildTree(leftPreorder, leftInorder);
		// 切出右子树的前序和中序
		int[] rightPreorder = Arrays.copyOfRange(preorder, 1 + leftSize, preorder.length);
		int[] rightInorder = Arrays.copyOfRange(inorder, leftSize + 1, preorder.length);
		root.right = buildTree(rightPreorder, rightInorder);
		return root;
	}
}
