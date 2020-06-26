package array;

import java.util.ArrayList;
import java.util.Arrays;

public class Primary6 {
	public static int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
			if(nums1[i] == nums2[j]) {
				list.add(nums1[i]);
				i++;
				j++;
			}
			else if(nums1[i] > nums2[j]) {
				j++;
			}
			else
				i++;
		}
		int nums3[] = new int[list.size()];
		for(int i = 0;i < list.size();i++) {
			nums3[i] = list.get(i);
		}
		return nums3;
	}
}
