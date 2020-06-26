package math;

public class Middle1 {
	public int squareSum(int n) { 	// 计算各位数字之和
		int sum = 0;
		while (n > 0) {
			int digit = n % 10;
			sum += digit * digit;
			n /= 10;
		}
		return sum;
	}
	//无限循环就一定是走到了环,而不是链表上的数字越变越大,数学上可以证明
	public boolean isHappy(int n) { 		// 重点在于判断是否出现循环
		int slow = n, fast = squareSum(n);
		while (slow != fast) {
			slow = squareSum(slow);
			fast = squareSum(squareSum(fast));
		}
		return slow == 1;	//若无限循环始终不变到1，则非快乐数
	}
}
