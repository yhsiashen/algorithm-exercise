package org.yuhang.algorithm.leetcode.linkedlist;

/**
 * 合并K个排序链表 两两链表逐个合并 23
 * Created by chinalife on 2018/11/27.
 */
public class ProblemMergeKLists {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode mergeKLists(ListNode[] lists) {
        if(lists ==null || lists.length==0)
            return null;
        ListNode currentresult = lists[0];
        for (int i = 1; i < lists.length; i++) {
            currentresult = mergeTwoLists(currentresult,lists[i]);
        }
        return currentresult;
    }


    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        //l1和l2的头指针
        ListNode p = l1;
        ListNode q = l2;

        ListNode result = new ListNode(1);
        //result的头指针
        ListNode current = result;
        while (p!=null||q!=null){
           if(p==null){
               current.next = new ListNode(q.val);
               q=q.next;
               current = current.next;
           }else if(q==null){
               current.next = new ListNode(p.val);
               p = p.next;
               current = current.next;
           }else {
               if(p.val<=q.val){
                   current.next = new ListNode(p.val);
                   p = p.next;
                   current = current.next;
               }else {
                   current.next = new ListNode(q.val);
                   q = q.next;
                   current = current.next;
               }
           }
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(5);
        lists[0] = listNode1;

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);
        lists[1] = listNode2;

        ListNode listNode3 = new ListNode(2);
        listNode3.next = new ListNode(6);
        lists[2] = listNode3;

        new ProblemMergeKLists().mergeKLists(lists);
    }
}
