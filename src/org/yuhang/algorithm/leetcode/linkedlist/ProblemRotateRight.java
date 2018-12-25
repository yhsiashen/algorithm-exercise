package org.yuhang.algorithm.leetcode.linkedlist;

/** 给定一个链表，将它的每个位置旋转k位 61
 * Created by chinalife on 2018/10/22.
 */
public class ProblemRotateRight {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
       if(head == null)
           return null;
       if(k <=0)
           return head;
        //计算链表长度，旋转的次数对链表长度取余
        int length = 0;
        ListNode p = head;
        while (p!=null){
            length++;
            p = p.next;
        }

        int ks = k%length;
        for (int i = 0; i < ks; i++) {
            head = rotateRight(head);
        }
        return head;
    }

    //将链表向右旋转1位
    public ListNode rotateRight(ListNode head){
        if(head.next==null)
            return head;
        ListNode p = head;
        while (p.next.next!=null){
            p = p.next;
        }
        ListNode rotate = p.next;
        p.next = null;
        rotate.next = head;
        return rotate;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        new ProblemRotateRight().rotateRight(node,20000);

    }
}
