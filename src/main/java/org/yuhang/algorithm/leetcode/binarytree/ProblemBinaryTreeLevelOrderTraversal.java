package org.yuhang.algorithm.leetcode.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层次遍历 LC102
 */
public class ProblemBinaryTreeLevelOrderTraversal {



     // Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

      public class HeightTreeNode{
          TreeNode node;
          int level;

          public HeightTreeNode(TreeNode node, int level) {
              this.node = node;
              this.level = level;
          }
      }

    public List<List<Integer>> levelOrder(TreeNode root) {
          List<List<Integer>> res = new ArrayList<>();
          if(root == null) return res;
          Queue<HeightTreeNode> queue = new LinkedList<>();
          queue.offer(new HeightTreeNode(root,1));
          while (!queue.isEmpty()){
              HeightTreeNode cur = queue.poll();
              if(cur.node!=null){
                 if(cur.node.left!=null) queue.offer(new HeightTreeNode(cur.node.left,cur.level+1));
                 if(cur.node.right!=null) queue.offer(new HeightTreeNode(cur.node.right,cur.level+1));
                  List<Integer> tmp;
                 if(cur.level > res.size()){
                      tmp = new ArrayList<>();
                      tmp.add(cur.node.val);
                      res.add(tmp);
                  }else{
                      tmp = res.get(cur.level-1);
                      tmp.add(cur.node.val);
                      res.add(tmp);
                 }
              }
          }

          return res;
    }
}
