package sortandsearch;

public class Hard3 {
	public double findMedianSortedArrays1(int[] nums1, int[] nums2) { // 方法1：暴力解
		int[] newArr = mergeTwoSortedArray(nums1, nums2);
		int n = newArr.length;
		if (n % 2 == 0) { // 偶数
			return (double) (newArr[n / 2] + newArr[n / 2 - 1]) / 2;
		} else { // 奇数
			return (double) newArr[n / 2];
		}
	}

	private int[] mergeTwoSortedArray(int[] nums1, int[] nums2) { // 合并两个数组
		int m = nums1.length;
		int n = nums2.length;
		int[] res = new int[m + n];
		int i = 0;
		int j = 0;
		int idx = 0;
		while (i < m && j < n) {
			if (nums1[i] <= nums2[j]) {
				res[idx++] = nums1[i++];
			} else {
				res[idx++] = nums2[j++];
			}
		}
		while (i < m) { // 未遍历完，则直接添加
			res[idx++] = nums1[i++];
		}
		while (j < n) { // 未遍历完，则直接添加
			res[idx++] = nums2[j++];
		}
		return res;
	}

}
