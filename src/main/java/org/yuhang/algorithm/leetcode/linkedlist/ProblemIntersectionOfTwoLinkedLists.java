package org.yuhang.algorithm.leetcode.linkedlist;

/**
 * 找相交链表的相交节点 LC160
 *
 */
public class ProblemIntersectionOfTwoLinkedLists {


     //Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }

    /**
     * 思想： 两个指针分别走过相同的路程: 交点之前的A链表+交点之前的B链表长度,然后之后的那个节点肯定为交点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }


}
