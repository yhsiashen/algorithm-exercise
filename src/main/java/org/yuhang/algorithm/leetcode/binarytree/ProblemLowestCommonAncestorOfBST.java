package org.yuhang.algorithm.leetcode.binarytree;


/**
 * 二叉搜索树的最近公共祖先 LC235
 *
 */
public class ProblemLowestCommonAncestorOfBST {



     // Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
          if(root == null) return null;
          if(p == root || q == root) {
              return root; //若p和q中有一个为根节点，则公共祖先为root
          }else if(p.val < root.val && q.val < root.val) {
              return lowestCommonAncestor(root.left,p,q);
          }else if(p.val>root.val && q.val>root.val){
              return lowestCommonAncestor(root.right,p,q);
          }else{
              return root;
          }
    }
}
