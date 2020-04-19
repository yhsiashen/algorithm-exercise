package org.yuhang.algorithm.review;

/**
 * 两两交换链表中的节点 LC24
 */
public class SwapNodesInPairs {


    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next !=null && p.next.next!=null){
            ListNode pnext = p.next;
            p.next = pnext.next;
            pnext.next = pnext.next.next;
            p.next.next = pnext;
            p = pnext;
        }

        return dummy.next;

    }
}
