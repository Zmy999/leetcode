package leetcode;

import java.util.HashMap;

public class Leetcode337 {
	// 直接暴力解：爷爷+四个孙子节点偷的的钱比较两个儿子节点偷得的钱，比较取最大值
	public int rob(TreeNode root) {
		if (root == null)
			return 0;

		int money = root.val;
		if (root.left != null) {
			money += (rob(root.left.left) + rob(root.left.right));
		}

		if (root.right != null) {
			money += (rob(root.right.left) + rob(root.right.right));
		}

		return Math.max(money, rob(root.left) + rob(root.right));
	}

	public int rob2(TreeNode root) {
		// 引入map，做记忆化搜索
		HashMap<TreeNode, Integer> memo = new HashMap<>();
		// 爷爷在计算自己能偷多少钱的时候，同时计算了 4 个孙子能偷多少钱，也计算了 2 个儿子能偷多少钱
		return robInternal(root, memo);
	}

	public int robInternal(TreeNode root, HashMap<TreeNode, Integer> memo) {
		if (root == null)
			return 0;
		// 记忆化搜索保存了结果，则取出该结果
		if (memo.containsKey(root))
			return memo.get(root);
		int money = root.val;

		if (root.left != null) {
			money += (robInternal(root.left.left, memo) + robInternal(root.left.right, memo));
		}
		if (root.right != null) {
			money += (robInternal(root.right.left, memo) + robInternal(root.right.right, memo));
		}
		int result = Math.max(money, robInternal(root.left, memo) + robInternal(root.right, memo));
		// 保存当前节点的最大金额
		memo.put(root, result);
		return result;
	}

	public int rob3(TreeNode root) {
		// 我们使用一个大小为 2 的数组来表示 int[] res = new int[2] 0 代表不偷，1 代表偷
		int[] result = robInternal(root);
		return Math.max(result[0], result[1]);
	}

	public int[] robInternal(TreeNode root) {
		if (root == null)
			return new int[2];
		int[] result = new int[2];
		// 同样相当于返回res数组
		int[] left = robInternal(root.left);
		int[] right = robInternal(root.right);
		// 当前节点选择不偷：当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
		result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		// 当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数
		result[1] = left[0] + right[0] + root.val;

		return result;
	}
}
