package org.yuhang.algorithm.leetcode.linkedlist;

/**
 * 分隔链表 86
 */
public class ProblemPartitionList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode partition(ListNode head, int x) {
      ListNode less = new ListNode(0);
      ListNode lessCur = less;
      ListNode more = new ListNode(0);
      ListNode moreCur = more;
      while (head!=null){
          if(head.val < x){
              lessCur.next = head;
              head = head.next;
              lessCur = lessCur.next;
          }else {
              moreCur.next = head;
              head = head.next;
              moreCur = moreCur.next;
          }
      }

      lessCur.next = more.next;
      moreCur.next = null;
      return less.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        new ProblemPartitionList().partition(head,3);
    }
}
