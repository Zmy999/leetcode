package leetcode;

public class Leetcode86 {
	public ListNode partition(ListNode head, int x) {
		// 记录小值链表的头
		ListNode minLink = new ListNode(0);
		// 对小表操作用的指针
		ListNode minP = minLink;
		// 记录大值链表的头
		ListNode maxnLink = new ListNode(0);
		// 对大表操作用的指针
		ListNode maxP = maxnLink;
		while (head != null) {
			// 找到小的值
			if (head.val < x) {
				// 放入minLink中，操作指针后移一位
				minP.next = head;
				minP = head;
			} else {
				// 放入maxLink中，操作指针后移一位
				maxP.next = head;
				maxP = head;
			}
			head = head.next;
		}
		// 遍历完成后记得后一段链表的最后节点指向null;
		maxP.next = null;
		// 两段拼接
		minP.next = maxnLink.next;
		return minLink.next;
	}
}
