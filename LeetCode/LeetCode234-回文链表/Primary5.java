package linkedlist;

import java.util.Stack;

public class Primary5 {
	 public boolean isPalindrome(ListNode head) {
		Stack<ListNode> stack = new Stack<ListNode>();
		ListNode cur = head;
		while(cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		while(head != null) {
			if(head.val != stack.pop().val) {
				return false;
			}
			head = head.next;
		}
		return true;
	 }
}
