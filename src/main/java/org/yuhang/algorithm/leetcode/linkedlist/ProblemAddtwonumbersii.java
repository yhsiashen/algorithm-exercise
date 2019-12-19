package org.yuhang.algorithm.leetcode.linkedlist;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 两数相加 LC445
 */
public class ProblemAddtwonumbersii {


     // Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0) return l2;
        if (l2.val == 0) return l1;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode res = null;
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int a = 0, b = 0;
            if (!stack1.isEmpty()) a = stack1.pop();
            if (!stack2.isEmpty()) b = stack2.pop();
            int c = (a + b + carry) % 10;
            carry = (a + b + carry) / 10;
            ListNode curNode = new ListNode(c);
            curNode.next = res;//将链表节点倒序连接
            res = curNode;
        }
        if(carry!=0){
            ListNode curNode = new ListNode(carry);
            curNode.next = res;
            res = curNode;
        }
        return res;
    }

}
