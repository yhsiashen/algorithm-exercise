package org.yuhang.algorithm.leetcode.binarytree;


/**
 * 二叉树的直径 LC543
 * @tag:二叉树
 */
public class ProblemDiameterOfBinaryTree {

     // Definition for a binary tree node.
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }


    int res = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode node){
        if(node==null) return 0;
        int left = dfs(node.left);
        int rigth = dfs(node.right);
        res = Math.max(res,rigth+left);
        return Math.max(left,rigth)+1;
    }


    public static void main(String[] args) {
        TreeNode root =  new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        new ProblemDiameterOfBinaryTree().diameterOfBinaryTree(root);
    }

}
