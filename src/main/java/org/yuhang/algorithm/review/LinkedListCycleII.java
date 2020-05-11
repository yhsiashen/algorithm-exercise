package org.yuhang.algorithm.review;

import java.util.HashSet;

/**
 * 环形链表II LC142
 */
public class LinkedListCycleII {

    /**
     * 用额外空间
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }
        if(fast==null || fast.next==null){//没有环
            return null;
        }

        HashSet<ListNode> set = new HashSet<>();
        while (!set.contains(slow)){
            set.add(slow);
            slow = slow.next;
        }
        while (!set.contains(head)){
            head = head.next;
        }

        return head;
    }

    /**
     * 不用额外空间
     * @param head
     * @return
     */
    public ListNode detectCycle1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }
        if(fast==null || fast.next==null){//没有环
            return null;
        }
        while (slow!=head){
            slow = slow.next;
            head = head.next;
         }
         return slow;

    }
}
