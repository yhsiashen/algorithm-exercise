package org.yuhang.algorithm.leetcode.LinkedList;

import java.util.List;

/**
 * 返回链表开始入环的那个节点，若没有环，则返回null
 * Created by chinalife on 2018/10/24.
 */
public class ProblemDetectCycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode output = null;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                output = fast;
                output.next = null;
                return output;
            }
        }
        return null;
    }

}
