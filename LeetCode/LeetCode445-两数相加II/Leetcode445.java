package leetcode;

import java.util.Stack;

public class Leetcode445 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = null;
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		// 处理链表节点，放入栈中
		while (l1 != null) {
			s1.push(l1.val);
			l1 = l1.next;
		}
		while (l2 != null) {
			s2.push(l2.val);
			l2 = l2.next;
		}
		// 进位标志位
		int carry = 0;
		while (!s1.isEmpty() || !s2.isEmpty()) {
			int sum = 0;
			int x = s1.isEmpty() ? 0 : s1.pop();
			int y = s2.isEmpty() ? 0 : s2.pop();
			sum = x + y + carry;
			carry = sum / 10;
			ListNode curr = new ListNode(sum % 10);
			// 从末尾开始逐步相加
			curr.next = head;
			head = curr;
		}
		// 处理进位
		if (carry != 0) {
			ListNode curr = new ListNode(carry);
			curr.next = head;
			head = curr;
		}
		return head;
	}
}
