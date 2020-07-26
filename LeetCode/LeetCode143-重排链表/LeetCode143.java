package leetcode;

public class LeetCode143 {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return;
		}
		// 快慢指针划分链表
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// 找到待反转链表的头节点
		ListNode newHead = slow.next;
		slow.next = null;
		// 第二个链表倒置
		newHead = reverseList(newHead);
		// 链表节点依次连接
		while (newHead != null) {
			ListNode temp = newHead.next;
			newHead.next = head.next;
			head.next = newHead;
			head = newHead.next;
			newHead = temp;
		}
	}
	// 反转链表
	private ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode p = null; // 先前节点
		ListNode q = null; // 临时变量
		while (head != null) {
			q = head.next; // 临时保存下一节点
			head.next = p;
			p = head;
			head = q; // 移动指针，处理下一节点
		}
		return p;
	}
}
