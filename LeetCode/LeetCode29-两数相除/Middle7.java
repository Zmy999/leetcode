package math;

public class Middle7 {
	// 被除数 除 除数
	public int divide(int dividend, int divisor) {
		// 除数为1，返回被除数
		if (divisor == 1) {
			return dividend;
		}
		// 除数 divisor 为 -1 时，被除数 dividend 为最小值则溢出，返回最大值
		// 否则，返回 -dividend
		if (divisor == -1) {
			return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
		}
		// 标记被除数和除数是否同为正或同为负
		boolean sign = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
		// 先将被除数和除数都转化为负数
		dividend = dividend > 0 ? -dividend : dividend;
		divisor = divisor > 0 ? -divisor : divisor;
		int result = div(dividend, divisor);
		// 根据标记，返回结果
		return sign ? result : -result;
	}
	
	// 注意，此时被除数和除数都是负数
	int div(int dividend, int divisor) {
		if (dividend > divisor) {
			return 0;
		}
		int result = 1;
		int temp = divisor;
		// 将除法转化为减法
		while (temp >= dividend - temp) {
			temp += temp;
			result += result;
		}
		return result + div(dividend - temp, divisor);
	}
}
