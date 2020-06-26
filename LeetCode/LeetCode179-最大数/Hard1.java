package math;

import java.util.ArrayList;
import java.util.Comparator;

public class Hard1 {
	public String largestNumber(int[] nums) {
		String temp;
		//元素放进集合
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			list.add(nums[i]);
		}
		//集合中进行排序，自定义比较器，数字以自定义的大小排列（转换成字符串，正反拼接比较），较大的放后面
		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if ((o1.toString() + o2.toString()).compareTo(o2.toString() + o1.toString()) > 0)
					return 1;
				else
					return -1;
			}
		});
		 // 集合末尾为0则全为0，此时返回字符串0
		if (list.get(list.size() - 1) == 0) {
			return "0";
		}
		temp = "";
		//因为大的在后面，所以反向相加
		while (!list.isEmpty()) {
			temp = temp + list.remove(list.size() - 1);
		}
		return temp;
	}
}
