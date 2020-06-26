package math;

public class Primary2 {

	public static int countPrimes(int n) {
		//定义一个信号数组默认为false 将所有以当前质数为因子的数都标记为非质数true
		boolean[] sign = new boolean[n + 1];
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (sign[i] == false) {
				count++;
				for (int j = i + i; j < n; j += i) { // 标记为非质数
					sign[j] = true;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(countPrimes(10));
	}
}
