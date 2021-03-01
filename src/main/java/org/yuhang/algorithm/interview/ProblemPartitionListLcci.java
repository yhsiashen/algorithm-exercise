package org.yuhang.algorithm.interview;

/**
 * 分隔链表 面试题2.04
 */
public class ProblemPartitionListLcci {



      //Definition for singly-linked list.
      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }


    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        ListNode lowSentry = new ListNode(0);
        ListNode low = lowSentry;
        ListNode highSentry = new ListNode(0);
        ListNode high = highSentry;
        while (head!=null){
           if(head.val < x){
               low.next = head;
               low = low.next;
//               low.next = null;
           }else {
                high.next = head;
                high = high.next;
//                high.next = null;
           }
           head = head.next;
        }
        low.next = highSentry.next;
        return lowSentry.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next= new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        new ProblemPartitionListLcci().partition(head, 3);
    }


}
