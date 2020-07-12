package leetcode;

public class Leetcode92 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null)
			return head;
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode p = dummyHead;
		ListNode q = dummyHead.next;
		int step = 0;
		while (step < m - 1) {
			// p移动到第一个要反转的结点前
			p = p.next;
			// q移动到第一个要发转的结点
			q = q.next;
			step++;
		}
		// n-m表示要移动几次
		for (int i = 0; i < n - m; i++) {
			ListNode temp = q.next;
			q.next = q.next.next;
			temp.next = p.next;
			p.next = temp;
		}
		return dummyHead.next;
	}
}
