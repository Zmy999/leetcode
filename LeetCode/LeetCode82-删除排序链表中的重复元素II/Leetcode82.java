package leetcode;

public class Leetcode82 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		// 新建一个哑结点用作边界处理。
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode a = dummy;
		ListNode b = head;
		while (b != null && b.next != null) {
			// 初始化的时a指向的是哑结点，所以比较逻辑应该是a的下一个节点和b的下一个节点
			if (a.next.val != b.next.val) {
				a = a.next;
				b = b.next;
			} else {
				// 如果a、b指向的节点值相等，就不断移动b，直到a、b指向的值不相等
				while (b != null && b.next != null && a.next.val == b.next.val) {
					b = b.next;
				}
				a.next = b.next;
				b = b.next;
			}
		}
		return dummy.next;
	}
}
