package sortandsearch;

public class Middle5 {

	public int[] searchRange(int[] nums, int target) {
		int[] result = new int[] {-1, -1};
		if (null == nums || nums.length == 0)
			return result;
		int j = nums.length - 1;			//从后向前遍历
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target && result[0] == -1) {
				result[0] = i;
			}
			if (nums[j] == target && result[1] == -1) {
				result[1] = j;
			}
			j--;
		}
		return result;
	}
}
