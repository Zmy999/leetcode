package dp;

public class Middle1 {
	public boolean canJump(int[] nums) {
		int n = 1;
		for(int i=nums.length-2; i>=0; i--){	//从倒数第二位开始筛选
			if(nums[i] >= n) {					//说明从此位置可以到达最后一位，将此位置作为最后一位
				n = 1;
			}
			else {								//继续向前遍历看能否到达最后一位
				n++;							//此处主要处理0
			}
			if(i == 0 && n > 1) {				//遍历结束
				return false;
			}
		}
		return true;
    }
}
