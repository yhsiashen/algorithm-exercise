package org.yuhang.algorithm.leetcode.backtracealgo;

import java.util.HashMap;

/**
 * 路径总和III LC437
 */
public class ProblemPathSumIII {


     // Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }


    /**
     * 双重递归、深搜
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
          if(root == null) return 0;
          return dfs(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
    }

    private int dfs(TreeNode root, int sum) {
        if(root==null) return 0;
        int res = 0;
        if(root.val == sum) res+=1;
        res+=dfs(root.left,sum-root.val);
        res+=dfs(root.right,sum-root.val);
        return res;
    }


    public int pathSum1(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        return helper(root, map, sum, 0);
    }
    int helper(TreeNode root, HashMap<Integer, Integer> map, int sum, int pathSum){
        int res = 0;
        if(root == null) return 0;
        pathSum += root.val;
        res += map.getOrDefault(pathSum - sum, 0);
        map.put(pathSum, map.getOrDefault(pathSum, 0) + 1);
        res = helper(root.left, map, sum, pathSum) + helper(root.right, map, sum, pathSum) + res;
        map.put(pathSum, map.get(pathSum) - 1);
        return res;
    }


    public static void main(String[] args) {

    }
}
