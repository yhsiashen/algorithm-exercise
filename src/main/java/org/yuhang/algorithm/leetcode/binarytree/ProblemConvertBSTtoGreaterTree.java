package org.yuhang.algorithm.leetcode.binarytree;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Stack;

/**
 * 将二叉搜索树转换为累加树
 * @tag:二叉树
 */
public class ProblemConvertBSTtoGreaterTree {


     // Definition for a binary tree node.
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    int preNum;

    /**
     * 递归、深搜
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
          if(root!=null){
              convertBST(root.right);
              root.val += preNum;
              preNum = root.val;
              convertBST(root.left);
          }
          return root;
    }


    /**
     * 栈
     * @param root
     * @return
     */
    public TreeNode convertBST1(TreeNode root){
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        int preNum = 0;
        while (node!=null || !stack.isEmpty()){
            while (node!=null){
                stack.push(node);
                node = node.right;
            }

            node = stack.pop();
            node.val += preNum;
            preNum = node.val;
            node = node.left;
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        new ProblemConvertBSTtoGreaterTree().convertBST(root);
    }
}
