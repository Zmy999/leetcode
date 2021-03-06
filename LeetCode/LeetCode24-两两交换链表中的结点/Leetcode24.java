package leetcode;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Leetcode24 {
	public ListNode swapPairs(ListNode head) {
		ListNode pre = new ListNode(0);
		pre.next = head;
		ListNode temp = pre;
		while (temp.next != null && temp.next.next != null) {
			ListNode start = temp.next;
			ListNode end = temp.next.next;
			temp.next = end;
			start.next = end.next;
			end.next = start;
			temp = start;
		}
		return pre.next;
	}
}
