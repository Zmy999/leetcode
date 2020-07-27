package leetcode;
import java.util.HashSet;

public class Leetcode349 {
	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };
		System.out.println(intersection(nums1, nums2));
	}

	public static int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> set1 = new HashSet<Integer>();
		HashSet<Integer> set2 = new HashSet<Integer>();
		for (int num : nums1)
			set1.add(num);
		for (int num : nums2) {
			if (set1.contains(num)) {
				set2.add(num);
			}
		}
		// 初始化结果数组集
		int[] newNum = new int[set2.size()];
		int j = 0;
		// 直接增强遍历即可
		for (int i : set2) {
			newNum[j] = i;
			j++;
		}
		return newNum;
	}
}
