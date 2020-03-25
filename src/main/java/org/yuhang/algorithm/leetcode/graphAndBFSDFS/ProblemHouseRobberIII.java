package org.yuhang.algorithm.leetcode.graphAndBFSDFS;

import java.util.HashMap;
import java.util.Map;

public class ProblemHouseRobberIII {

     // Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    Map<TreeNode,Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        if(root == null) return 0;
        if(map.containsKey(root)) return map.get(root);
        int left = 0;
        int right = 0;
        if(root.left!=null) {
            left = rob(root.left.left)+rob(root.left.right);
        }
        if(root.right!=null){
            right = rob(root.right.left)+rob(root.right.right);
        }

        int res =  Math.max(left+right+root.val, rob(root.left)+rob(root.right));
        map.put(root,res);
        return res;
    }
}
