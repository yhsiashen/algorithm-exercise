package org.yuhang.algorithm.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的后序遍历 145
 */
public class ProblemPostorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
//        postorderByRecur(root,list);
//        postorderByIterator(root,list);
        postorderByReserve(root,list);
        return list;

    }

    /**
     * 递归
     * @param node
     * @param list
     */
    private void postorderByRecur(TreeNode node,List<Integer> list){
        if(node == null) return;
        postorderByRecur(node.left,list);
        postorderByRecur(node.right,list);
        list.add(node.val);
    }

    /**
     * 用stack辅助，迭代法
     * @param node
     * @param list
     */
    private void postorderByIterator(TreeNode node,List<Integer> list){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        //标识此节点被访问过
        TreeNode visited= node;
        while (!stack.isEmpty()){
           TreeNode top = stack.peek();
           if((top.left==null && top.right==null) || top.left == visited || top.right == visited){
               list.add(top.val);
               stack.pop();
               visited = top;
           }else {
               if(top.left!=null) stack.push(top.left);
               if(top.right!=null) stack.push(top.right);
           }
        }
    }


    /**
     * 用stack辅助，迭代翻转法，将根->右->左 翻转成 左->右->根
     * @param node
     * @param list
     */
    private void postorderByReserve(TreeNode node,List<Integer> list){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        List<Integer> reserveList = new ArrayList<>();
        while (!stack.isEmpty()){
            TreeNode top = stack.pop();
            //加入list的顺序为根->右->左，则反过来为后序遍历,即将list取反即可
            reserveList.add(top.val);
            if(top.left!=null) stack.push(top.left);
            if(top.right!=null) stack.push(top.right);
        }
        for (int i = reserveList.size()-1; i >=0; i++) {
            list.add(reserveList.get(i));
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        new ProblemPostorderTraversal().postorderTraversal(root);
    }
}
