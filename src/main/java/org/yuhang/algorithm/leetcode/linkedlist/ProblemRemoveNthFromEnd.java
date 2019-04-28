package org.yuhang.algorithm.leetcode.linkedlist;


/**
 * 删除链表倒数第n个节点  19
 */
public class ProblemRemoveNthFromEnd {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    /**
     * 两次遍历，先求长度，再定位到要删除的节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        int length = 0; //链表长度
        while (head!=null){
            head = head.next;
            length++;
        }
        ListNode pre = dummyNode;
        for (int i = 0; i < length-n; i++) {
            pre = pre.next;//找到要删除节点的前置节点
        }
        pre.next = pre.next.next;
        return dummyNode.next;
    }

    /**
     * 双指针法一次遍历定位到要删除的节点！
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n){
        if(head == null) return null;
        ListNode p = head;
        ListNode q = head;
        for (int i = 0; i < n; i++) {
            p = p.next;
        }

        if(p==null) return head.next;

        while (p.next!=null) {
            p = p.next;
            q = q.next;
        }

        q.next = q.next.next;
        return head;


    }
}
