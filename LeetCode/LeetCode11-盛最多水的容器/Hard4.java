package array;

public class Hard4 {
	public static void main(String[] args) {
		int height[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(maxArea(height));
	}

	public static int maxArea(int[] height) {		//双指针法
		int i = 0, j = height.length - 1, res = 0;
		while (i < j) {
			res = height[i] < height[j] ? 
					Math.max(res, (j - i) * height[i++]) : Math.max(res, (j - i) * height[j--]);
		}
		return res;
	}
}
