package array;

public class Middle2 {
	public void setZeroes(int[][] matrix) {
		boolean[] judgeX = new boolean[matrix.length]; // 获取行数
		boolean[] judgeY = new boolean[matrix[0].length]; // 获取列数
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					judgeX[i] = true;
					judgeY[j] = true;
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (judgeX[i] || judgeY[j]) { // 行或列中有元素为0，则该行或该列置0
					matrix[i][j] = 0;
				}
			}
		}
	}
}
