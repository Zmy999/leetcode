package array;

import java.util.ArrayList;
import java.util.List;

public class hard2 {
	public List<Integer> spiralOrder(int[][] matrix) {		//模拟遍历
		if (matrix == null || matrix.length == 0) {
			return new ArrayList<>();
		}
		int minX = 0;
		int maxX = matrix.length - 1;					//行
		int minY = 0;
		int maxY = matrix[0].length - 1;				//列
		ArrayList<Integer> res = new ArrayList<>();
		int size = matrix.length * matrix[0].length;	//总共需要遍历的节点数
		while (minX <= maxX && minY <= maxY) {
			// 向右遍历，x不变，y增大
			for (int y = minY; y <= maxY; y++) {
				res.add(matrix[minX][y]);
			}
			if (res.size() == size) {					//判断遍历是否完成
				break;
			}
			minX++;
			// 向下遍历，y不变，x增大
			for (int x = minX; x <= maxX; x++) {
				res.add(matrix[x][maxY]);
			}
			if (res.size() == size) {					//判断遍历是否完成
				break;
			}
			maxY--;
			// 向左遍历，x不变，y减小
			for (int y = maxY; y >= minY; y--) {
				res.add(matrix[maxX][y]);
			}
			if (res.size() == size) {					//判断遍历是否完成
				break;
			}
			maxX--;
			// 向上遍历，y不变，x减小
			for (int x = maxX; x >= minX; x--) {
				res.add(matrix[x][minY]);
			}
			if (res.size() == size) {					//判断遍历是否完成
				break;
			}
			minY++;
		}
		return res;
	}
}
