package org.yuhang.algorithm.leetcode.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 判断二叉树是否是对称二叉树 101
 */
public class ProblemSymmetric {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 递归法，先翻转右子树，再判断左右子树是否相等 或者 直接镜像比较(左和右的值相等,右和左的值相等)
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
       if(root == null) return true;
       //翻转右子树
       reserveTree(root.right);
       //判断左右子树是否一样，不一样则返回错误
        return isSameTree(root.left, root.right);
    }

    private void reserveTree(TreeNode node){
        if(node == null) return;
        //交换左右子节点的位置
        TreeNode left = node.left;
        TreeNode right = node.right;
        node.right = left;
        node.left = right;
        reserveTree(node.left);
        reserveTree(node.right);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null) return false;
        if(q==null) return false;
        if(p.val!=q.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }


    /**
     * 迭代法-两个队列实现
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
        if(root==null) return true;
        Deque<TreeNode> leftQueue = new ArrayDeque<>();
        Deque<TreeNode> rightQueue = new ArrayDeque<>();
        leftQueue.offer(root.left);
        rightQueue.offer(root.right);


        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()){
                TreeNode leftLast = leftQueue.poll();
                TreeNode rightLast = rightQueue.poll();
                //队列头部节点都为空,直接判断下一组节点
                if(leftLast==null && rightLast ==null) continue;
                //队列头部节点有一个为空，直接返回false
                if(leftLast==null || rightLast ==null) return false;
                //队列头部节点值不等，直接返回false
                if(leftLast.val != rightLast.val) return false;
                leftQueue.offer(leftLast.left);
                leftQueue.offer(leftLast.right);
                rightQueue.offer(rightLast.right);
                rightQueue.offer(rightLast.left);

            }

        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);
        new ProblemSymmetric().isSymmetric1(root);
    }
}
