package org.yuhang.algorithm.leetcode.binarytree;

import java.util.*;

/**
 * 二叉树的最大宽度 LC662
 */
public class ProblemMaximumWidthOfBinaryTree {


     // Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

      public class AnnotatedNode{
          TreeNode node;
          int depth;
          int pos;

          public AnnotatedNode(TreeNode node, int depth, int pos) {
              this.node = node;
              this.depth = depth;
              this.pos = pos;
          }
      }


    public int widthOfBinaryTree(TreeNode root) {
        Queue<AnnotatedNode> queue = new LinkedList<>();
        queue.add(new AnnotatedNode(root,1,1));
        int curDepth = 1,left = 1, ans = 0;
        while (!queue.isEmpty()){
           AnnotatedNode top = queue.poll();
           if(top.node!=null){
               queue.add(new AnnotatedNode(top.node.left,top.depth+1,top.pos*2));
               queue.add(new AnnotatedNode(top.node.right,top.depth+1,top.pos*2+1));
               if(curDepth!=top.depth){
                   curDepth = top.depth;
                   left = top.pos;
               }
               ans = Math.max(ans,top.pos-left+1);
           }
        }
        return ans;

    }

}
