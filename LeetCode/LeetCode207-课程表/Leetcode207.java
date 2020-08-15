package leetcode;

import java.util.ArrayList;
import java.util.List;

// 通过 DFS 判断图中是否有环
public class Leetcode207 {
	public boolean canFinish(int numCourses, int[][] prerequisites) {	
		// 初始化
		List<List<Integer>> adjacency = new ArrayList<>();
		for (int i = 0; i < numCourses; i++)
			adjacency.add(new ArrayList<>());
		// 标记列表，用于判断每个节点（课程）的状态
		int[] flags = new int[numCourses];
		for (int[] cp : prerequisites)
			adjacency.get(cp[1]).add(cp[0]);
		// 对 numCourses 个节点依次执行 DFS，判断每个节点起步 DFS 是否存在环，若存在环直接返回 FalseFalse
		for (int i = 0; i < numCourses; i++)
			if (!dfs(adjacency, flags, i))
				return false;
		return true;
	}

	// 未被 DFS 访问：i == 0
	private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
		// 已被当前节点启动的 DFS 访问：i == 1
		if (flags[i] == 1)
			return false;
		// 已被其他节点启动的 DFS 访问：i == -1
		if (flags[i] == -1)
			return true;
		// 将当前访问节点 i 对应 flag[i] 置 11，即标记其被本轮 DFS 访问过；
		flags[i] = 1;
		// 递归访问当前节点 i 的所有邻接节点 j，当发现环直接返回 FalseFalse；
		for (Integer j : adjacency.get(i))
			if (!dfs(adjacency, flags, j))
				return false;
		// 当前节点所有邻接节点已被遍历，并没有发现环，则将当前节点 flag 置为 -1 并返回 True。
		flags[i] = -1;
		// 若整个图 DFS 结束并未发现环，返回 True。
		return true;
	}
}
