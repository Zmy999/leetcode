package linkedlist;

public class Primary7 {
	public boolean hasCycle(ListNode head) {
		ListNode slow = head;
		if (slow == null)
			return false;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			if (slow == fast) // 若有环则总有追上的一天
				return true;
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
	}
}
