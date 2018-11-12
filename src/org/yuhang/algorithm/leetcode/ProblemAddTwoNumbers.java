package org.yuhang.algorithm.leetcode;

/**
 * 将存放在链表中的两数相加
 * Created by chinalife on 2018/11/12.
 */
public class ProblemAddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return null;
    }

    //链表反转
    public void reserveList(ListNode list){
        ListNode preNode = null;
        while (list.next!=null){
             preNode = list;
             list = list.next;
             preNode.next = null;



        }

    }
}
