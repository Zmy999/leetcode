package leetcode;

// 每个元素最多出现两次
public class LeetCode80 {
	public int removeDuplicates(int[] nums) {
		int slow = 0;
		// 增加一个重复个数的状态
		int repeatNum = 1;
		for (int fast = 1; fast < nums.length; fast++) {
			if (nums[fast] != nums[slow]) {
				nums[++slow] = nums[fast];
				// 计数清除
				repeatNum = 1;
			} else {
				// 如果重复次数小于2次，还可以移动s
				if (repeatNum < 2) {
					// 如果快指针和慢指针不是挨着，就需要赋值
					nums[++slow] = nums[fast];
					// 重复次数增加
					repeatNum++;
				}
			}
		}
		return slow + 1;
	}

	// 方法二
	public int removeDuplicates2(int[] nums) {
		int i = 0;
		for (int n : nums) {
			if (i < 2 || n > nums[i - 2])
				nums[i++] = n;
		}
		return i;
	}
	
	// 方法3：覆盖多余的重复项
	public int removeDuplicates3(int[] nums) {
		// count用于记录当前数字出现的次数
		int j = 1, count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				count++;
			} else {
				// 遇到了新元素，重置count
				count = 1;
			}
			// count > 2，则保持j不动
			// count <= 2，则将 i 所指向的元素移动到 j 位置，并同时增加 i 和 j。
			if (count <= 2) {
				nums[j++] = nums[i];
			}
		}
		return j;
	}
}
