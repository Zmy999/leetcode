package array;

public class Primary1 { 
	public static int removeDuplicates1(int[] nums) {	//普通方法
		if (nums.length == 0 || nums.length == 1) {
			return nums.length;
		}
		int temp = nums[0];								//临时变量temp初值为nums[0]
		int k = 1;										//计数器
		for (int i = 1; i < nums.length; i++) {
			if (temp != nums[i]) {						//此时不等，则说明之前的都相等
				temp = nums[i];							//从此点处继续遍历
				nums[k] = nums[i];
				k++;
			}
		}
		return k;
	}
	
	public static int removeDuplicates2(int[] nums) {		//双指针法
		if (nums.length == 0 || nums.length == 1) {
			return nums.length;
		}
        int i = 0;									//i为慢指针
        for(int j = 1; j < nums.length; j++) {		//j为快指针	
            if(nums[j] != nums[i]) {  
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
	}
	
}
