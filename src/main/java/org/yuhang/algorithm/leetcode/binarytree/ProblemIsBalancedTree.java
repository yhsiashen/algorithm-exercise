package org.yuhang.algorithm.leetcode.binarytree;

/**
 * 判断一棵树是否为平衡二叉树(左右子树相差不超过1) LC110
 */
public class ProblemIsBalancedTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 自顶而下，暴力的判断每个子树是否为平衡二叉树，O(nlogn)
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        //判断根节点是否平衡
        if(Math.abs(maxDepth(root.left)-maxDepth(root.right))>1){
            return false;
        }
        //遍历左子树，判断左子树的每个节点是否平衡
        if(!isBalanced(root.left))
            return false;
        //遍历右子树，判断右子树的每个节点是否平衡
        if(!isBalanced(root.right))
            return false;
        return true;
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }


    /**
     * 自底而上，避免高度的大量重复计算，O(n)
     * @param root
     * @return
     */
    public boolean isBalanced1(TreeNode root){
        return recur(root)!=-1;
    }

    private int recur(TreeNode node) {
        if(node == null) return 0;
        int left = recur(node.left);//先递归求最底层的叶子节点，看是否满足平衡
        if(left==-1) return -1;
        int right = recur(node.right);
        if(right==-1) return -1;
        return Math.abs(left-right) <=1?Math.max(left,right)+1:-1;//若node的左右子树差大于1，则返回-1；否则返回node的高度
    }


}
