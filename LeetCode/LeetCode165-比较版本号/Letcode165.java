package leetcode;

public class Letcode165 {
	public int compareVersion(String version1, String version2) {
		// 思路，从左到右一个一个版本号对比
		int len1 = version1.length();
		int len2 = version2.length();
		int startIndex1 = 0, endIndex1 = 0, startIndex2 = 0, endIndex2 = 0;
		while (endIndex1 < len1 || endIndex2 < len2) {
			// 先找V1的最左边的版本号
			int num1 = 0;
			for (; endIndex1 < len1; endIndex1++) {
				if (version1.charAt(endIndex1) == '.')
					break;
			}
			// 如果开始和结束的位置不相等，说明当前可以截取字段，如果相等，就默认用0替代，用于后面的比较
			if (endIndex1 != startIndex1) {
				num1 = Integer.valueOf(version1.substring(startIndex1, endIndex1));
			}
			// 再找V2的最左边的版本号
			int num2 = 0;
			for (; endIndex2 < len2; endIndex2++) {
				if (version2.charAt(endIndex2) == '.')
					break;
			}
			// 如果开始和结束的位置不相等，说明当前可以截取字段，如果相等，就默认用0替代，用于后面的比较
			if (endIndex2 != startIndex2) {
				num2 = Integer.valueOf(version2.substring(startIndex2, endIndex2));
			}
			// 比较返回值
			if (num1 > num2)
				return 1;
			if (num1 < num2)
				return -1;
			startIndex1 = ++endIndex1;
			startIndex2 = ++endIndex2;
		}
		return 0;
	}
}
