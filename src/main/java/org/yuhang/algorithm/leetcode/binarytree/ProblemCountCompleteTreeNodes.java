package org.yuhang.algorithm.leetcode.binarytree;

/**
 * 完全二叉树的节点个数 LC222
 */
public class ProblemCountCompleteTreeNodes {


     // Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    /**
     * 方法1：遍历所有节点
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
          if(root==null) return 0;
          return countNodes(root.left)+countNodes(root.right)+1;
    }

    /**
     * 方法2：利用完全二叉树性质，比较左右子树高度后递归
     * @param root
     * @return
     */
    public int countNodes2(TreeNode root){
          if(root == null) return 0;
          int leftTreeHight = countLevel(root.left);
          int rightTreeHight = countLevel(root.right);
          if(leftTreeHight == rightTreeHight){
              return countNodes2(root.right)+(1<<leftTreeHight);
          }else{
              return countNodes2(root.left)+(1<<rightTreeHight);
          }
    }

    private int countLevel(TreeNode node){
          int level = 0;
          while (node!=null){
              level++;
              node = node.left;
          }
          return level;
    }

}
