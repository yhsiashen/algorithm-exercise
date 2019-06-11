package org.yuhang.algorithm.leetcode.binarytree;

/**
 * 祖先节点与节点差值的最大绝对值  1026
 */
public class ProblemMaximumDifferenceBetweenNodeAndAncestor {


     // Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public int maxAncestorDiff(TreeNode root) {
       if(root == null) return 0;
       if(root.left==null && root.right==null) return 0;
       int rootVal = root.val;


       return 0;
    }
}
