package linkedlist;

public class Middle1 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode pre = new ListNode(0);				//添加预先指针，作为新链表返回
		ListNode cur = pre;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int x = l1 == null ? 0 : l1.val;		//为空则补0
			int y = l2 == null ? 0 : l2.val;		//为空则补0
			int sum = x + y + carry;
			carry = sum / 10;
			sum = sum % 10;
			cur.next = new ListNode(sum);
			cur = cur.next;
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}
		if (carry == 1) {		//如果两个链表全部遍历完毕后，进位值为 11，则在新链表最前方添加节点 11
			cur.next = new ListNode(carry);
		}
		return pre.next;
	}
}
