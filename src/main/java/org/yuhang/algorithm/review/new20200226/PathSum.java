package org.yuhang.algorithm.review.new20200226;

import org.yuhang.algorithm.review.TreeNode;

/**
 * 04.12  求和路径
 */
public class PathSum {

    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        if(sum == root.val) return 1;
        return cal(root,sum-root.val) + pathSum(root.left,sum-root.val)+pathSum(root.right,sum-root.val);
    }

    private int cal(TreeNode root, int sum){
        if(root == null) return 0;
        int res=0;
        if(sum == root.val) res=1;//找到满足sum的路径后结果+1，但要继续遍历后面节点，因为可能存在负数导致后面也有满足条件的路径
        return res+cal(root.left, sum- root.val)+cal(root.right,sum-root.val);
    }

}
