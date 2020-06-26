package dp;

public class Primary1 {
	public int climbStairs1(int n) {
		int[] dp = new int[100000];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}
	
	public int climbStairs2(int n) {	//剪枝，迭代
		if(n < 1)
			return 0;
		if(n == 1)
			return 1;
		if(n == 2)
			return 2;
		int temp = 0;
		int f1 = 1;
		int f2 = 2;
		for(int i = 3;i <= n;i++) {		//每次仅需上两次结果，故仅需保留上两次结果即可
			temp = f1 + f2;
			f1 = f2;
			f2 = temp;
		}
		return temp;
	}
}
