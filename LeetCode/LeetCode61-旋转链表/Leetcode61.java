package leetcode;

public class Leetcode61 {
	public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        // 链表长度
        int length = 1;
        ListNode ptr = head;
        // ptr指向链表末尾
        while (ptr.next != null) {
            ptr = ptr.next;
            length++;
        }
        //获取实际需要移动的步数(注意，此处考虑移动次数大于链表长度)
        int step = k % length;
        //不需要移动
        if (step == 0) {
            return head;
        }
        //尾首相连
        ptr.next = head;
        // 在合适的位置断开
        return moveHelper(head, step, length);
    }

    private ListNode moveHelper(ListNode head, int step, int length) {
        int count = 0;
        ListNode temp = head;
        //找到链表需要断开的位置
        while (count < length - step - 1) {
            temp = temp.next;
            count++;
        }
        //获取结果链表的起点
        ListNode res = temp.next;
        temp.next = null;
        return res;
    }
}
