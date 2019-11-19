package org.yuhang.algorithm.leetcode.linkedlist;

/**
 * 移除链表指定元素 LC203
 */
public class ProblemRemoveLinkedListElements {


     //Definition for singly-linked list.
      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }


    public ListNode removeElements(ListNode head, int val) {
          ListNode dummy = new ListNode(0);
          dummy.next = head;
          ListNode p = dummy;
          while (p.next !=null){
              if(p.next.val == val){
                  ListNode pnext= p.next.next;
                  p.next = pnext;
                  pnext = null;//help gc
              }else{
                  p = p.next;
              }

          }
          return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(6);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(6);
        new ProblemRemoveLinkedListElements().removeElements(head,6);
    }
}
