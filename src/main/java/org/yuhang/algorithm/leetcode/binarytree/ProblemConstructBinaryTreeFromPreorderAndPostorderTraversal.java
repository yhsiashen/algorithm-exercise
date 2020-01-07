package org.yuhang.algorithm.leetcode.binarytree;

/**
 * 根据前序遍历和后序遍历构造二叉树 LC889
 */
public class ProblemConstructBinaryTreeFromPreorderAndPostorderTraversal {


     //Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }


      public TreeNode constructFromPrePost(int[] pre, int[] post) {
          return construct(pre,post,0,pre.length-1,0,post.length-1);
      }

      public TreeNode construct(int[] pre,int[] post,int s1,int s2,int p1, int p2){
          TreeNode root = new TreeNode(pre[s1]);//前序遍历的s1位置为root节点
          if(s1 >= s2) return root;
          int ls1 = s1+1;
          int lp1 = p1;
          int lp2 = p1;
          while (post[lp2]!= pre[ls1]){
              lp2++;
          }
          int ls2 = lp2-lp1+s1+1;
          root.left = construct(pre,post,ls1,ls2,lp1,lp2);
          int rs1 = ls2+1;
          int rs2 = s2;
          int rp1 = lp2+1;
          int rp2 = p2-1;
          root.right = construct(pre,post,rs1,rs2,rp1,rp2);
          return root;
      }

    public static void main(String[] args) {
        int[] pre = {1,2,4,5,3,6,7};
        int[] post = {4,5,2,6,7,3,1};
        new ProblemConstructBinaryTreeFromPreorderAndPostorderTraversal().constructFromPrePost(pre,post);
    }
}
