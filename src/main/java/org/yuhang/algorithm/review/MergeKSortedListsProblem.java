package org.yuhang.algorithm.review;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并K个排序链表 23
 */
public class MergeKSortedListsProblem {

     // Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }


    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0 || lists[0]==null) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        ListNode head = new ListNode(0);
        ListNode p = head;
        for(ListNode listNode:lists) queue.offer(listNode);
        while (!queue.isEmpty()){
            ListNode top = queue.poll();
            p.next = top;
            p = p.next;
            if(top.next!=null) queue.offer(top.next);
        }
        return head.next;

    }
}
