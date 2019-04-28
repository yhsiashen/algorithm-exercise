package org.yuhang.algorithm.leetcode.binarytree;


/**
 * 判断两个二叉树是否为同一个树
 */
public class ProblemSameTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 遍历两树，若有不相同的点，则直接返回false
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
       if(p==null && q==null) return true;
       if(p==null) return false;
       if(q==null) return false;
       if(p.val!=q.val) return false;
       return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
