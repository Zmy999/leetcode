package linkedlist;
import linkedlist.ListNode;

public class Primary2 {
	 public ListNode removeNthFromEnd(ListNode head, int n) {
		 if (head == null || n <= 0)
			 return head;
		 ListNode cur = head;			//当前节点
	     ListNode pre = head;			//当前节点的前一个节点
	     for(int i = 0;i < n;i++) {		//删除倒数第n个，则cur走n步
	    	 cur = cur.next;
	     }
	     if(cur == null){
	        head = head.next;
	        return head;
	     }
	     while(cur.next != null){		//cur走到末尾时，pre正好指向倒数第n个
	    	 cur = cur.next;
	         pre = pre.next;
	     }
	     pre.next=pre.next.next;
		 return head;
	    }
}
