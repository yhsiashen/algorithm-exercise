package org.yuhang.algorithm.leetcode.binarytree;

import java.util.*;

/**
 * 二叉树层次遍历  102
 */
public class ProblemLevelOrder {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 两个队列实现
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Deque<TreeNode> deque = new ArrayDeque<>();
        Deque<TreeNode> nextDeque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            TreeNode p = deque.poll();
            list.add(p.val);
            if(p.left!=null) nextDeque.offer(p.left);
            if(p.right!=null) nextDeque.offer(p.right);
            //代表该层已遍历完
            if(deque.isEmpty()){
                result.add(list);
                //将下层节点队列赋给当前节点队列
                deque = nextDeque;
                //将下层节点队列指向一个新的空的队列
                nextDeque = new ArrayDeque<>();
                //将存储层节点的list指向一个新的空list
                list = new ArrayList<>();
            }
        }
        return result;
    }

    /**
     * 一个队列实现
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            int levelNum = deque.size();
            List<Integer> list = new ArrayList<>();
            while (levelNum > 0){
                TreeNode p = deque.poll();
                list.add(p.val);
                if(p.left!=null) deque.offer(p.left);
                if(p.right!=null) deque.offer(p.right);
                levelNum--;
            }
            //层遍历完，将list加入result中
            result.add(list);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        new ProblemLevelOrder().levelOrder(root);
    }
}
