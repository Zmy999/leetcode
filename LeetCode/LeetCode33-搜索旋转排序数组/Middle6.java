package sortandsearch;

public class Middle6 {
	public int search(int[] nums, int target) {	// 分治法，双指针
		if (nums.length == 0)
			return -1;
		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {
			int mid = (end + start) / 2;

			if (nums[mid] == target) {
				return mid;
			}

			if (nums[mid] >= nums[start]) {
				if (target >= nums[start] && target < nums[mid]) {
					end = mid - 1;		//左
				} else {
					start = mid + 1;	//右
				}
			} else {
				if (target > nums[mid] && target <= nums[end]) {
					start = mid + 1;	//左
				} else {
					end = mid - 1;		//右
				}
			}
		}
		return -1;
	}
}
