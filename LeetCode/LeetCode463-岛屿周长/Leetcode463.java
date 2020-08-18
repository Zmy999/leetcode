package leetcode;

public class Leetcode463 {
	// 岛屿的周长就是岛屿方格和非岛屿方格相邻的边的数量
	public int islandPerimeter(int[][] grid) {
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				if (grid[r][c] == 1) {
					// 题目限制只有一个岛屿，计算一个即可
					return dfs(grid, r, c);
				}
			}
		}
		return 0;
	}

	int dfs(int[][] grid, int r, int c) {
		// 从一个岛屿方格走向网格边界，周长加 1
		if (!(0 <= r && r < grid.length && 0 <= c && c < grid[0].length)) {
			return 1;
		}
		 // 从一个岛屿方格走向水域方格，周长加 1
		if (grid[r][c] == 0) {
			return 1;
		}
		// 已遍历过（值为2）的岛屿在这里会直接返回，不会重复遍历
		if (grid[r][c] != 1) {
			return 0;
		}
		// 将方格标记为已遍历
		grid[r][c] = 2;
		return dfs(grid, r - 1, c) + dfs(grid, r + 1, c) + dfs(grid, r, c - 1) + dfs(grid, r, c + 1);
	}
}
