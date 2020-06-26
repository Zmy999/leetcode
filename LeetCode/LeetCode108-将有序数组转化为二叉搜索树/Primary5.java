package tree;

public class Primary5 {
	public TreeNode sortedArrayToBST(int[] nums) {
		return initTree(nums, 0, nums.length - 1);
	}

	private TreeNode initTree(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = initTree(nums, start, mid - 1);
		root.right = initTree(nums, mid + 1, end);
		return root;
	}
}
