package org.yuhang.algorithm.leetcode.linkedlist;


/**
 * 两两交换链表中的节点  24
 */
public class ProblemSwapPairs {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next==null) return head;
        ListNode result = head.next;
        ListNode p = head;
        ListNode preNode = new ListNode(0); //用一个链表哨兵，表示p节点之前的一个节点
        while (p!=null && p.next!=null) {
            ListNode pnext = p.next;
            p.next = p.next.next;
            pnext.next = p;
            preNode.next = pnext; // 将p节点之前的节点指向此时的pnext节点
            preNode = p; //将preNode位置指向p
            p = p.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
//        list.next.next.next = new ListNode(4);
        new ProblemSwapPairs().swapPairs(list);
    }
}
