package org.yuhang.algorithm.rowtooffer;

/**
 * 找到两个链表第一个公共节点
 * Created by chinalife on 2018/6/5.
 */
public class Problem27 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null)
            return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = (p1 == null ? pHead1 : p1.next);
            p2 = (p2 == null ? pHead2 : p2.next);
        }
        return p1;
    }

    public static void main(String[] args) {
          ListNode pHead1 = new ListNode(2);
          ListNode pHead2 = new ListNode(3);
          pHead1.next = new ListNode(3);
          pHead2.next = new ListNode(5);
          new Problem27().FindFirstCommonNode(pHead1,pHead2);

    }

}