package array;

public class Middle6 {
	public static boolean increasingTriplet(int[] nums) {
		if (nums==null||nums.length<3) 
			return false;
        int big=Integer.MAX_VALUE,small=Integer.MAX_VALUE;
        for (int i:nums){
            if (i <= small) 
            	small = i;
            else if (i <= big) 		// 走到这一步说明这个值大于前面的值(i>small)
            	big = i;
            else 					// 走到这一步说明这个值大于前面的两个值（i>big>small）
            	return true;
        }
        return false;		
    }
	public static void main(String[] args) {
		int nums[] = {2,1,5,0,4,6};
		System.out.println(increasingTriplet(nums));
	}
}
