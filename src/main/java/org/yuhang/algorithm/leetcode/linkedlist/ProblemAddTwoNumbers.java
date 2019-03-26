package org.yuhang.algorithm.leetcode.linkedlist;

/**
 * 将存放在链表中的两数相加,双指针法
 * Created by chinalife on 2018/11/12.
 */
public class ProblemAddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null)
            return null;
        //p,q分别指向l1,l2的头结点
        ListNode p = l1;
        ListNode q = l2;
        //结果链表
        ListNode result =new ListNode(3);
        ListNode resultHead = result;
        //进位
        int carry = 0;
        //遍历l1,l2,逐位相加
        while (p != null || q != null) {
            int x = p == null ? 0 : p.val;
            int y = q == null ? 0 : q.val;
            int sum = x + y + carry;
            carry = sum / 10;
            int z = sum % 10;
            resultHead.next = new ListNode(z);
            resultHead = resultHead.next;
            p = p == null ? null : p.next;
            q = q == null ? null : q.next;
        }
        if(carry==1){
            resultHead.next= new ListNode(1);
        }

        return result.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        new ProblemAddTwoNumbers().addTwoNumbers(l1, l2);
    }
}
