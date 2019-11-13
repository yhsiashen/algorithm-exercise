package org.yuhang.algorithm.leetcode.linkedlist;


import java.util.List;

/**
 * 对链表进行插入排序 LC147
 */
public class ProblemInsertSortList {


      // Definition for singly-linked list.
      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }


    public ListNode insertionSortList(ListNode head) {
        if(head ==null) return null;
        ListNode sentry = new ListNode(0),pre; //哨兵节点
        sentry.next = head;
        while (head!=null && head.next!=null){
            if(head.val <= head.next.val) {
                head = head.next;
                continue;
            }
            pre = sentry;
            //head后面一个节点为待插入的节点
            while (pre.next.val < head.next.val) pre = pre.next; //从哨兵节点开始往后找第一个大于待插入节点的前驱节点，即为pre
            ListNode cur  = head.next; // cur节点为待排序节点
            head.next = cur.next; // head为已排序好的最后一个节点
            cur.next = pre.next; //pre为节点要插入位置的前驱节点
            pre.next = cur;

        }

        return sentry.next;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(6);
        list.next = new ListNode(5);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(1);
        list.next.next.next.next = new ListNode(8);
        new ProblemInsertSortList().insertionSortList(list);
    }
}
