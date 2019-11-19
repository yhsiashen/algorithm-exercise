package org.yuhang.algorithm.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 找二叉搜索树中第k小的元素 LC230
 */
public class ProblemKthSmallestElementinBST {


     // Definition for a binary tree node.
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }


    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        find(root,k,res);
        return res.get(k-1);
    }

    private void find(TreeNode node,int k,List<Integer> res){
        if(node==null || res.size()==k) return;
        find(node.left,k,res);
        res.add(node.val);
        find(node.right,k,res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        new ProblemKthSmallestElementinBST().kthSmallest(root,3);
    }

}
