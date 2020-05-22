package org.yuhang.algorithm.leetcode.binarytree;

import org.yuhang.algorithm.review.TreeNode;

/**
 * 最大的二叉搜索树子树的节点个数 LC333
 */
public class ProblemLargestBSTSubstree {

    private int last = Integer.MIN_VALUE;
    private int ans = 0;

    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;
        bstSubtree(root);
        return ans;

    }

    private int bstSubtree(TreeNode root){
        if(root == null) return 0;
        int res = 0;
        int leftNum = bstSubtree(root.left);//返回为大于等于0的话则代表子树为二叉搜索树
        if(leftNum >=0 && root.val > last){
            last = root.val;
            int rightNum = bstSubtree(root.right);
            if(rightNum>=0){
                res += leftNum+rightNum+1;
                ans = Math.max(ans,res);
                return res;
            }
        }
        return -1;
    }


    public boolean isBST(TreeNode root){
        if(root == null) return true;
        if(isBST(root.left) && root.val > last){
            last = root.val;
            return isBST(root.right);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(16);
        root.right.right = new TreeNode(14);
        System.out.println(new ProblemLargestBSTSubstree().largestBSTSubtree(root));
    }
}
