package linkedlist;
import linkedlist.ListNode;

public class Primary1 {
	public static void deleteNode(ListNode node) {
		node.val = node.next.val;
        node.next = node.next.next;
    }
}
