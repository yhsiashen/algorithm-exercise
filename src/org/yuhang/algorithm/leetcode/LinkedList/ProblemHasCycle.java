package org.yuhang.algorithm.leetcode.LinkedList;

import java.util.List;

/**
 * 判断链表是否有环
 * Created by chinalife on 2018/10/24.
 */
public class ProblemHasCycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null )
            return false;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next !=null ){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
