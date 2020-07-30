package leetcode;

public class Leetcode367 {
	// 平方数性质，小于目标数的一半才有可能平方得到
	// 直接暴力求解会超时
	public boolean isPerfectSquare(int num) {
		if (num == 1)
			return true;
		int left = 1, right = num/2;
		while (left <= right) {
			int mid = left + ((right - left) >> 1);
			if ((long)mid * mid > num) {
				right = mid - 1;
			}
			else if((long)mid * mid < num){
				left = mid + 1;
			}
			else {
				return true;
			}
		}
		return false;
	}
}
