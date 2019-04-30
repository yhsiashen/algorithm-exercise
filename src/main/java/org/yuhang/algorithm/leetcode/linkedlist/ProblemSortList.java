package org.yuhang.algorithm.leetcode.linkedlist;


/**
 * 对链表排序，要求时间复杂度O(nlogn),空间复杂度为常数级别 148
 */
public class ProblemSortList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head; //为null或只有一个元素直接返回
        return mergeSortList(head);
    }

    /**
     * 归并法排序，将链表按中点分开，两边分别排序后再归并
     * @param start
     * @return
     */
    private ListNode mergeSortList(ListNode start) {
         if(start.next == null) return start; //只有一个节点时即返回
         ListNode fast = start;
         ListNode slow = start;
         ListNode pre = slow; //中间节点之前的节点
        while (fast!=null && fast.next!=null) { //找到中间节点
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }

        pre.next = null; //得到左边链表start
        ListNode left = mergeSortList(start); //得到排序后的左边链表
        ListNode rigth = mergeSortList(slow); //得到排序后的右边链表
        return mergeList(left,rigth); //归并俩排序链表
    }


    private ListNode mergeList(ListNode left, ListNode right) {
          ListNode p = left;
          ListNode q = right;
          ListNode r = new ListNode(0);
          ListNode result = r;
          while (p!=null && q!=null){
              if(p.val < q.val){
                  r.next = p; //将r的next指向p
                  r = r.next;
                  p = p.next;
              }else{
                  r.next = q;
                  r = r.next;
                  q = q.next;
              }
          }

          if (p!=null) r.next = p;
          if (q!=null) r.next = q;
          return result.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        new ProblemSortList().sortList(head);
    }
}
