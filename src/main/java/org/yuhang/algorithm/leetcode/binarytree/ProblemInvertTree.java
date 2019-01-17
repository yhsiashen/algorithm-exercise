package org.yuhang.algorithm.leetcode.binarytree;

/** 翻转二叉树 226
 * Created by chinalife on 2018/11/30.
 */
public class ProblemInvertTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        //将root的左右子树交换
        invertOneTree(root);
        //递归的将二叉树的左右节点的左右子树交换
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public void invertOneTree(TreeNode root){
        if(root ==null)
            return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
