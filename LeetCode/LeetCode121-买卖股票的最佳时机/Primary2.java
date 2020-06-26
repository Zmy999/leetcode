package dp;

public class Primary2 {
	 public static int maxProfit1(int[] prices) {			//暴力解法
		 if (prices == null || prices.length < 1) {
	            return 0;
	        }
		 int count = 0;
		 for(int i = 0;i < prices.length-1;i++) {
			 for(int j = i + 1;j < prices.length;j++){
				 if(prices[j] - prices[i] > count)
					 count = prices[j] - prices[i];
			 }
		 }
		 return count;
	 }
	 
	 public static int maxProfit2(int[] prices) {	 		//改进解法
		 if (prices == null || prices.length < 1) {
	            return 0;
	     }
		 int max = 0;
		 int min = prices[0];
		 for(int i = 1;i < prices.length;i++) {
			 if(prices[i] < min) {
				 min = prices[i];
			 }
			 else {
				 if(max < prices[i] - min)   
		         max = prices[i] - min;
			 }
		 }
		 return max;
	 }
}
