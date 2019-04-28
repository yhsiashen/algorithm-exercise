package org.yuhang.algorithm.leetcode.binarytree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树前序遍历 144
 */
public class ProblemPreorderTraversal {


    public  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null)  return list;
//        preorderByrecur(root,list);
        preorderByIterator(root,list);
        return list;

    }

    /**
     * 递归法
     * @param node
     * @param list
     */
    private void preorderByrecur(TreeNode node,List<Integer> list){
        if(node == null) return;
        list.add(node.val);
        preorderByrecur(node.left,list);
        preorderByrecur(node.right,list);
    }


    /**
     * 迭代法
     * @param node
     * @param list
     */
    private void preorderByIterator(TreeNode node,List<Integer> list){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            TreeNode top = stack.pop();
            list.add(top.val);
            if(top.right!=null) stack.push(top.right);
            if(top.left!=null) stack.push(top.left);
        }
    }
}
