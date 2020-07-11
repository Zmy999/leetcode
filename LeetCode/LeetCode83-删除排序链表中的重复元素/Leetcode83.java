package leetcode;

public class Leetcode83 {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode p = head;
		while(p != null && p.next != null) {
			if(p.val == p.next.val) {
				p.next = p.next.next;
			}
			else {
				p = p.next;
			}
		}
		return head;
    }
}
