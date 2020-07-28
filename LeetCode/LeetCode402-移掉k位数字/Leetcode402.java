package leetcode;
import java.util.Deque;
import java.util.LinkedList;

public class Leetcode402 {
	public String removeKdigits(String num, int k) {
		// 单调递增栈
		Deque<Character> deque = new LinkedList<>(); 
		char[] arr = num.toCharArray();

		// 遍历，逐个入队
		for (char c : arr) {
			// 新来的字符小于当前末尾字符，则删除当前末尾字符
			while (!deque.isEmpty() && k > 0 && deque.getLast() > c) {
				k--;
				deque.removeLast();
			}
			deque.addLast(c);
		}

		// k 还有余，考虑相等的字符和递增队列，故从末尾删除
		while (k-- > 0 && !deque.isEmpty())
			deque.removeLast();

		// 移除头部零
		while (!deque.isEmpty() && deque.getFirst() == '0')
			deque.removeFirst();
		
		// 判空
		if (deque.isEmpty())
			return "0";

		// 构建，返回
		char[] res = new char[deque.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = deque.removeFirst();
		}
		// 转换为字符串类型返回
		return new String(res);
	}
}
