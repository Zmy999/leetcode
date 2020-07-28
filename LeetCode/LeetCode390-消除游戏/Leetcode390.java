package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode390 {
	public int lastRemaining(int n) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		// 反转标志位
		boolean reverse = false;
		while (list.size() > 1) {
			list.removeAll(dele(list, reverse));
			reverse = !reverse;
		}
		return list.get(0);
	}

	public List<Integer> dele(List<Integer> list, boolean reverse) {
		List<Integer> dels = new ArrayList<>();
		if (reverse) {
			for (int i = list.size() - 1; i >= 0; i = i - 2) {
				dels.add(list.get(i));
			}
		} else {
			for (int i = 0; i < list.size(); i = i + 2) {
				dels.add(list.get(i));
			}
		}
		return dels;
	}
}
