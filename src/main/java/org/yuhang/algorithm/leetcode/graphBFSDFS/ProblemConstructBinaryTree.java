package org.yuhang.algorithm.leetcode.graphBFSDFS;

import java.util.Arrays;

/**
 *  从前序遍历和中序遍历序列构造二叉树 105
 */
public class ProblemConstructBinaryTree {

  
     // Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }


    /**
     * 先序遍历第一个元素一定是根元素
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
          if(preorder.length == 0) return null;
          if(preorder.length == 1) return new TreeNode(preorder[0]);
          TreeNode root = new TreeNode(preorder[0]);
          int rootIndex = 0; // inorder序列中根节点的索引位置
          while (true) {
              if (preorder[0] != inorder[rootIndex]) rootIndex++;
              else break;
          }

          int[] preLeft = Arrays.copyOfRange(preorder,1,rootIndex+1);
          int[] preRight = Arrays.copyOfRange(preorder,rootIndex+1,preorder.length);
          int[] inLeft = Arrays.copyOfRange(inorder,0,rootIndex);
          int[] inRight = Arrays.copyOfRange(inorder,rootIndex+1,inorder.length);
          root.left = buildTree(preLeft,inLeft);
          root.right = buildTree(preRight,inRight);
          return root;
    }

    public static void main(String[] args) {
          int[] pre = {3,9,20,15,7};
          int[] in = {9,3,15,20,7};
          new ProblemConstructBinaryTree().buildTree(pre,in);


    }


}
