package org.yuhang.algorithm.review;

/**
 * 二叉树中的最大路径和 LC124
 */
public class BinaryTreeMaximumPathSum {

    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMaxPathSum(root);
        return res;
    }

    /**
     * 返回左右子树路径和的较大值加上根节点的值，若有路径是负数，则舍弃负数
     * @param node
     * @return
     */
    private int getMaxPathSum(TreeNode node){
        if(node == null) return 0;
        int left = Math.max(0,getMaxPathSum(node.left));//如果左子树的路径小于0，则应该置成0将左子树排除到最大路径之外
        int right = Math.max(0,getMaxPathSum(node.right));
        res = Math.max(res, node.val+left+right);//比较一次路径与当前res的大小
        return Math.max(left,right)+node.val;
    }
}
