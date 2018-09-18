package com.chinalife.springmvc.algorithm.rowtooffer;

/**
 * 链表的第倒数k个节点
 * Created by chinalife on 2018/5/9.
 */
public class Problem14 {

    static class ListNode {
        public int data;
        public ListNode next;

        public ListNode(int data) {
            this.data = data;
        }

    }

    public static void insertNode(ListNode listNode, int i) {
        while (listNode.next != null) {
            listNode = listNode.next;
        }
        listNode.next = new ListNode(i);
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k < 0) {
            return null;
        }
        int length = 0;
        ListNode root = head;
        while (head.next != null) {
            length++;
            head = head.next;
        }
        length++;
        if (k > length) {
            return null;
        }
        int l = length - k + 1;
        while (l > 1) {
            root = root.next;
            l--;
        }
        System.out.println(root.data);
        return root;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        insertNode(head, 2);
        insertNode(head, 3);
        insertNode(head, 4);
        insertNode(head, 5);
        new Problem14().FindKthToTail(head, 1);

    }

}
