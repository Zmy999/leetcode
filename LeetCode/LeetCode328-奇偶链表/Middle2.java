package linkedlist;

public class Middle2 {
	 public ListNode oddEvenList(ListNode head) {
		 if (head == null || head.next == null) {
	            return head;
	     }
		 ListNode dummyHead = head;					//保存头节点
		 ListNode node = head.next;					
		 ListNode nextNode = head.next;	 			//保存第一个偶数节点用于连接
		 while (node != null && node.next != null) {
			 //依次将奇数节点连接
			 head.next = head.next.next;
			 head = head.next;
			 //依次将偶数节点链接
			 node.next = node.next.next;
			 node = node.next;
		 }
		 //将第一个偶数节点链接到最后一个奇数节点的后面
		 head.next = nextNode;
		 return dummyHead;
	 }
}
