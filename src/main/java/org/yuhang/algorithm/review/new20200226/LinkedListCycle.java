package org.yuhang.algorithm.review.new20200226;


import org.yuhang.algorithm.review.ListNode;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 返回链表入环的第一个节点，若链表无环，返回null
 */
public class LinkedListCycle {

    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        HashSet<ListNode> set = new HashSet<>();
        while (head!=null){
            if(set.contains(head)){
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    public ListNode detectCycle1(ListNode head) {
        if(head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next !=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){//快慢指针相遇
                slow = head;
                while (slow!=fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;//链表没环
    }
}
