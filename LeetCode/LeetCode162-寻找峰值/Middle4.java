package sortandsearch;

public class Middle4 {
	public static int findPeakElement(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
	            return i;
			}
		}
		return nums.length - 1;
	}
	public static void main(String[] args) {
		int nums[] = {1,2};
		System.out.println(findPeakElement(nums));
	}
}
