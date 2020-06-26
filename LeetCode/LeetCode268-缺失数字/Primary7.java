package math;

public class Primary7 {
	public int missingNumber(int[] nums) {
		int[] str = new int[nums.length + 1];
		for(int i = 0;i < nums.length;i++){
            str[nums[i]] = 1;
        }
		for(int j = 0;j < str.length;j++){
			if(str[j] == 0)
				return j;
		}
		return -1;
	}
}
