package org.yuhang.algorithm.leetcode.linkedlist;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 重排链表 143
 */
public class ProblemReorderList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    /**
     * 遍历
     * @param head
     */
    public void reorderList(ListNode head) {
        if(head ==null || head.next==null || head.next.next==null) return;
        ListNode p =head;
        while (p.next!=null && p.next.next!=null) {
            ListNode pnext = p.next;
            while (pnext.next != null && pnext.next.next!=null) {
                pnext = pnext.next;
            }

            ListNode last = pnext.next;
            pnext.next = null; //将最后一个节点断开
            //将最后一个节点插入到目前的p节点后面
            last.next = p.next;
            p.next = last;
            p = last.next;
        }
    }

    /**
     * 双向队列
     * @param head
     */
    public void reorderList1(ListNode head){
        if(head == null) return;
        Deque<ListNode> deque = new LinkedList<>();
        ListNode cur = head;
        while (cur!=null){ //将链表各节点放入队列中
            deque.add(cur);
            cur = cur.next;
        }

        while (!deque.isEmpty()){
            if(cur==null){
                cur = deque.poll();
            }else{
                cur.next = deque.poll(); //连接队头节点
                cur = cur.next;
            }

            cur.next = deque.pollLast(); //连接队尾节点
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new ProblemReorderList().reorderList1(head);
    }
}
