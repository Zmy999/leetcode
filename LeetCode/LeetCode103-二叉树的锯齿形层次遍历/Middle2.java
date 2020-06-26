package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Middle2 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		 List<List<Integer>> res = new LinkedList<>();
         if(root == null){
             return res;
         }
         LinkedList<TreeNode> queue = new LinkedList<>();
         queue.add(root);
         int depth = 0;
         while(!queue.isEmpty()) {
        	 int size = queue.size();
        	 LinkedList<Integer> currentRes = new LinkedList<>();
        	 while(size > 0) {								//每层有多少个元素
        		 TreeNode current = queue.poll();			//出队
        		 TreeNode left = current.left;
                 TreeNode right = current.right;
                 if (left != null) {						//层次遍历
                     queue.add(left);
                 }
                 if (right != null) {
                     queue.add(right);
                 }
                 if (depth % 2 != 0) {						//奇数层从头添加，偶数层从尾部添加
                     currentRes.add(0, current.val);	//奇
                 } else {	
                     currentRes.add(current.val);		//偶
                 }
                 size--;
        	 }
        	 res.add(currentRes);
             depth++;
         }
         return res;
    }
}
