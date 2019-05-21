package org.yuhang.algorithm.leetcode.linkedlist;

import java.util.Stack;

/**
 * 有序链表转二叉搜索树
 */
public class ProblemSortedListToBST {



      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }



    public TreeNode sortedListToBST(ListNode head) {
        return buildBST(head);
    }

    /**
     * 将链表重建为平衡的二叉搜索树
     * @return
     */
    private TreeNode buildBST(ListNode head){
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        //先找出链表中间节点
        ListNode slow  = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        ListNode p = head;
        while (p.next != slow){
            p = p.next;
        }
        p.next =null;
        root.left = buildBST(head);
        root.right = buildBST(slow.next);
        return root;
    }





    public static void main(String[] args) {
        ListNode list = new ListNode(-10);
        list.next = new ListNode(-3);
        list.next.next = new ListNode(0);
        list.next.next.next = new ListNode(5);
        list.next.next.next.next = new ListNode(9);
        new ProblemSortedListToBST().sortedListToBST(list);
    }
}
