package array;

public class Primary5 {
	 public static int singleNumber(int[] nums) {
		 int target = 0;
		 for(int i = 0;i < nums.length;i++) {
			 target ^= nums[i];					//异或
		 }
		 return target;
	 }

}
