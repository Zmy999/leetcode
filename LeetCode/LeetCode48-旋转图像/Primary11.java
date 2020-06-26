package array;

public class Primary11 {
	public void rotate(int[][] matrix) {
		 for(int i = 0;i<matrix.length;i++) {		//先行列转置
		        for (int j = i; j < matrix.length; j++) {
		            int temp = 0;
		            temp = matrix[i][j];
		            matrix[i][j] = matrix[j][i];
		            matrix[j][i] = temp;
		        }
		    }
		 for(int i =0 ; i<matrix.length; i++){		//再关于中心轴做镜像变换
		        for(int j = 0; j<matrix.length/2; j++){
		            int temp = 0;
		            temp = matrix[i][j];
		            matrix[i][j] = matrix[i][matrix.length-1-j];
		            matrix[i][matrix.length-1-j] = temp;
		        }
		    }
    }
}
