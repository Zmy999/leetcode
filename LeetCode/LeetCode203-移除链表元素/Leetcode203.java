package leetcode;

public class Leetcode203 {
	public ListNode removeElements(ListNode head, int val) {
		// 创建一个虚拟头结点
		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;
		ListNode pre = dummyNode;
		// 确保当前结点后还有结点
		while (pre.next != null) {
			if (pre.next.val == val) {
				pre.next = pre.next.next;
			} else {
				pre = pre.next;
			}
		}
		return dummyNode.next;
	}
}
