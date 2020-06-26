package linkedlist;
import linkedlist.ListNode;

public class Primary3 {
	public ListNode reverseList(ListNode head) {
		if(head == null){          
			return null;       
		}     
		ListNode p = null;       	//先前节点
		ListNode q = null;			//临时变量
		while(head != null){
			q = head.next;			//临时保存下一节点
			head.next = p;			
			p = head;				
			head = q;				//移动指针，处理下一节点
		}
		return p;
    }
}
