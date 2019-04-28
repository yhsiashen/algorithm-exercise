package org.yuhang.algorithm.leetcode.binarytree;

/**
 * 判断二叉树是否有满足给定值的路径之和  112
 */
public class ProblemHashPathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return findPathSum(root,0,sum);
    }

    private boolean findPathSum(TreeNode node,int pathSum,int sum) {
         if(node == null) return false;
         pathSum+=node.val;
         //此时已得到一条路径
         if(pathSum == sum && node.left==null && node.right==null) return true;
         return findPathSum(node.left,pathSum,sum) || findPathSum(node.right,pathSum,sum);
    }



}
