package org.yuhang.algorithm.leetcode.binarytree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历 LC94
 */
public class ProblemBinaryTreeInorderTraversal {



     //Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }


    public List<Integer> inorderTraversal(TreeNode root) {
          List<Integer> res = new ArrayList<>();
          Stack<TreeNode> stack = new Stack<>();
          TreeNode cur = root;
          while (!stack.isEmpty() || cur!=null){
              while (cur!=null){
                  stack.push(cur);
                  cur = cur.left;
              }
              cur = stack.pop();
              res.add(cur.val);
              cur = cur.right;

          }
         return res;
    }
}
