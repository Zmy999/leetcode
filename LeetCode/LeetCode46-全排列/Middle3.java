package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Middle3 {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();		//保存输出结果
		List<Integer> path = new ArrayList<>();				//保存每组排列
		int len = nums.length;
		if(len == 0)
			return res;
		boolean[] visited = new boolean[len];
		DFS(nums, len, 0, path, visited, res);
		return res;
    }
	//执行一次深度优先遍历，从树的根结点到叶子结点形成的路径就是一个全排列
	public void DFS(int[] nums, int len, int depth,List<Integer> path, 
			boolean[] visited,List<List<Integer>> res) {
		if(depth == len) {
			res.add(new ArrayList<>(path));		//java值传递
			return ;
		}
		for(int i = 0; i < len; i++) {
			if(!visited[i]) {
				path.add(nums[i]);
				visited[i] = true;
				DFS(nums, len, depth + 1, path, visited, res);	//保存访问过的节点并传递至下一次DFS
				visited[i] = false;						//状态重置
				path.remove(path.size()-1);				//回头
			}
		}
	}
}
