package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Primary4 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<>();
		if (root == null) {
			return ret;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root); 										// 先将根节点放入队列中
		while (!q.isEmpty()) {
			int size = q.size(); 							// size为当前层的元素个数
			List<Integer> level = new ArrayList<>(size); 	// 用level来保存一层元素
			for (int i = 0; i < size; i++) {
				TreeNode cur = q.poll();
				level.add(cur.val); 						// 将当前层节点值放进level中
				if (cur.left != null) { 					// 如果节点有左孩子，就将左孩子入队列
					q.offer(cur.left);
				}
				if (cur.right != null) { 					// 如果节点有右孩子，就将右孩子入队列
					q.offer(cur.right);
				}
			}
			ret.add(level); 								// 每遍历完一层就将当前层结果放入ret中
		}
		return ret;
	}
}
