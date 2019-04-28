package org.yuhang.algorithm.leetcode.linkedlist;


/**
 * 反转链表中的一段节点  92
 */
public class ProblemReverseBetween {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 一个一个交换,用到哨兵节点简化编程
     *  1->2->3->4->5
     *  1->3->2->4->5
     *  1->4->3->2->5
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
         if(head==null || head.next ==null || m <1 || n<1 || n<m) return head;
         ListNode dummyNode = new ListNode(0);
         dummyNode.next = head;
         ListNode pre = dummyNode; //m位置的前驱节点
        for (int i = 0; i < m-1; i++) {
            pre  = pre.next;
        }
        ListNode currenNode = pre.next; //开始翻转的节点
        for (int i = m; i < n; i++) { //做n-m次操作
            ListNode nextNode = currenNode.next;
            currenNode.next = nextNode.next;
            nextNode.next = pre.next;
            pre.next = nextNode;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);

        new ProblemReverseBetween().reverseBetween(list,1,3);
    }
}
