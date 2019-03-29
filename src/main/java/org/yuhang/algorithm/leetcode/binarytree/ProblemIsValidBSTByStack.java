package org.yuhang.algorithm.leetcode.binarytree;

import java.util.Stack;

/**
 * 验证二叉树是否为二叉搜索树 98
 */

public class ProblemIsValidBSTByStack {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }


    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        Stack<Integer> stack = new Stack<Integer>();

        return midOrderTree(root, stack);
    }

    /**
     * 用栈维护一个从小到大的队列，若比较当时的value比栈顶元素小，则直接返回错
     * @param node
     * @param stack
     * @return
     */
    public boolean midOrderTree(TreeNode node, Stack<Integer> stack) {
        // 判断左子树是否为有序,若不为则不是BST
        if (node.left != null) {
            if (!midOrderTree(node.left, stack))
                return false;
        }
        // 判断当前节点与前一个节点的大小,若<=,则不为BST
       if(stack.isEmpty()){
            stack.push(node.val);
       }else {
           if(node.val <= stack.pop()){
               return false;
           }else {
               stack.push(node.val);
           }
       }

        // 判断右子树是否为有序
        if (node.right != null) {
            if (!midOrderTree(node.right, stack))
                return false;
        }
        //全部遍历完均为有序则为BST
        return true;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(1);
        System.out.println(new ProblemIsValidBSTByStack().isValidBST(node));
    }
}
