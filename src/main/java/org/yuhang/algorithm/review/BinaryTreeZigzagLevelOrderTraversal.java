package org.yuhang.algorithm.review;

import java.util.*;

/**
 * 二叉树的锯齿形层序遍历 LC103
 */
public class BinaryTreeZigzagLevelOrderTraversal {



     // Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> res = new ArrayList<>();
         if(root == null) return res;
         Deque<TreeNode> deque = new ArrayDeque<>();
         deque.offer(root);
         boolean reverse = false;
         while (!deque.isEmpty()){
             int size = deque.size();
             List<Integer> list =  new ArrayList<>();
             while (size > 0){
                 TreeNode node = deque.poll();
                 if(node.left!=null) deque.offer(node.left);
                 if(node.right!=null) deque.offer(node.right);
                 list.add(node.val);
                 size--;
             }
             if(reverse){
                 Collections.reverse(list);
             }
             reverse = !reverse;
             res.add(list);
         }

         return res;
    }
}
