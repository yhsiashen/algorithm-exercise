package org.yuhang.algorithm.leetcode.binarytree;


import java.util.*;

/**
 * 将二叉树按Z形遍历  103
 * Created by chinalife on 2018/11/29.
 */
public class ProblemZigzagLevelOrder {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //结果集合
        List<List<Integer>> resultList = new ArrayList<>();

        if (root == null)
            return resultList;

        //用双向队列存储每层节点，后进先出
        Deque<TreeNode> queue = new LinkedList<>();
        Deque<TreeNode> nextQueue = new LinkedList<>();
        List<Integer> everyList = new ArrayList<>();
        queue.add(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode current = queue.pollLast();
            everyList.add(current.val);
            if(flag){
                if(current.right!=null)
                    nextQueue.add(current.right);
                if(current.left!=null)
                    nextQueue.add(current.left);
            } else {
                if(current.left!=null)
                    nextQueue.add(current.left);
                if(current.right!=null)
                    nextQueue.add(current.right);
            }
            if(queue.isEmpty()){
                queue = nextQueue;
                //将nextQueue变量指向一个新的空队列
                nextQueue = new LinkedList<>();
                //变换方向
                flag=!flag;
                //将每层的list添加到总的list中
                resultList.add(everyList);
                //将everylist变量指向一个新的空list
                everyList = new ArrayList<>();
            }
        }

        return resultList;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        new ProblemZigzagLevelOrder().zigzagLevelOrder(node);

    }
}
