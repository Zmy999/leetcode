package dp;

public class Primary4 {
	public static int rob1(int[] nums) {				//贪心，递归处理
		 int n = nums.length;
		 int money[] = new int[n];
		 if (n == 0)			//处理空值
			 return 0;
		 if(n == 1)				//只有一家，打劫他
			 return nums[0];
		 int twoMax = Math.max(nums[0], nums[1]);
		 if(n == 2)				//如果有两家，选最高的打劫
			 return twoMax;
		 money[0] = nums[0];	//只有一家
		 money[1] = twoMax;		//有两家，取最大
		 //dp分步考虑
		 //偷 nums[n] ，则一定不能偷 nums[n-1]。在这种情况下最大的收益为 money(n-2)+nums[n]
		 //不偷 nums[n]。这种情况下，最大的收益为 money(n-1)
		 for(int i = 2;i < money.length;i++) {
			 money[i] = Math.max(money[i - 2] + nums[i], money[i - 1]);	//选较大值作为打劫到第 i 家的最大价值
		 }
		 return money[n-1];
    }
	
	public static int rob2(int[] nums) {		//奇偶分步解法
		int sumOdd = 0;//奇数
	    int sumEven = 0;//偶数
		for(int i = 0;i < nums.length;i++) {
			if(i % 2 == 0) {
				sumEven += nums[i];
				sumEven = Math.max(sumEven, sumOdd);
			}
			else {
				sumOdd += nums[i];
				sumOdd = Math.max(sumEven, sumOdd);
			}
		}
		return Math.max(sumEven, sumOdd);
	}
}
