package linkedlist;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Hard2 {
	public ListNode sortList(ListNode head) {
		if( head == null ){
            return head;
        }
		List<ListNode> list = new LinkedList<ListNode>();
		ListNode node = head;
		while(node != null ){		//链表中的每个节点加入list
            list.add(node);
            node = node.next;
         }
		list.sort(new Comparator<ListNode>() {		//重写排序
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val > o2.val ? 1 : (o1.val == o2.val ? 0 : -1);
            }
        });
		head = new ListNode(0);			//头节点head指向0
		ListNode r = head;
		for (ListNode n : list) {		//遍历list集合，依次添加排序后的node节点
            r.next = n;
            r = n;
        }
        r.next = null;					//最后一个节点的next置空处理
        return head.next;				//由于新定义了一个头节点用于连接，故返回时排除该节点
    }
}
