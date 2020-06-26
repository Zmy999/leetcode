package map;

public class Middle1 {
	public void DFS(char[][] grid, int i, int j, int xLen, int yLen) {
		if (i < 0 || i >= xLen || j < 0 || j >= yLen || grid[i][j] == '0') {
			return;
		}
		// 将能DFS到的 1 都变为 0，岛屿数 +1,没被DFS到则表明不相连，为另外的岛屿
		grid[i][j] = '0'; 				
		DFS(grid, i - 1, j, xLen, yLen);		//对假定岛屿上下左右进行遍历，查看有无相连
		DFS(grid, i, j - 1, xLen, yLen);
		DFS(grid, i + 1, j, xLen, yLen);
		DFS(grid, i, j + 1, xLen, yLen);
	}

	public int numIslands(char[][] grid) {
		if(grid == null || grid.length == 0){
            return 0;
        }
		int xLen = grid.length;						//行数
        int yLen = grid[0].length;					//列数
        int sum = 0;
        for(int i = 0;i < xLen;i++) {
        	for(int j = 0;j < yLen;j++) {
        		if(grid[i][j] == '1') {
        			sum++;							//岛屿数量加1
        			DFS(grid, i, j, xLen, yLen);
        		}
        	}
        }
        return sum;
	}
}
