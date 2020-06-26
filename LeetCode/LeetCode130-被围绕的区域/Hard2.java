package tree;

public class Hard2 {
	public void solve(char[][] board) {
		//任何边界上的'O'都不会被填充为'X'
		//任何不在边界上，或不与边界上的'O'相连的'O'最终都会被填充为'X'
		if (board == null || board.length <= 1 || board[0].length <= 1) {
			return;
		}
		for (int i = 0; i < board.length; i++) {		//处理两个边界
			if (board[i][0] == 'O') {					//左边界
				dfs(board, i, 0);
			}
			if (board[i][board[0].length - 1] == 'O') {	//右边界
				dfs(board, i, board[0].length - 1);
			}
		}
		for (int j = 0; j < board[0].length; j++) {		//处理两个边界
			if (board[0][j] == 'O') {					//上边界
				dfs(board, 0, j);
			}
			if (board[board.length - 1][j] == 'O') {	//下边界
				dfs(board, board.length - 1, j);
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '+') {
					board[i][j] = 'O';
				} else if (board[i][j] == 'O') {	//被'X'包裹的'O'，替换为'X'
					board[i][j] = 'X';
				}
			}
		}
	}

	private void dfs(char[][] board, int row, int col) {
		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
			return;
		}
		if (board[row][col] != 'O')
			return;
		board[row][col] = '+';
		//从为'O'的点出发，查看周围是否有'O'
		dfs(board, row + 1, col);
		dfs(board, row, col + 1);
		dfs(board, row - 1, col);
		dfs(board, row, col - 1);
	}
}
