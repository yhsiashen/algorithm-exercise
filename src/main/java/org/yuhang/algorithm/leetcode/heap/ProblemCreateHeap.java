package org.yuhang.algorithm.leetcode.heap;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**  堆的建立与维护
 * Created by chinalife on 2018/11/29.
 */
public class ProblemCreateHeap {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> lists = new LinkedList<>();
        if(root == null){
            return lists;
        }

        int flag = 0;
        //0：从左向右，1：从右向左


        List<Integer> layer = new LinkedList<>();

        Deque<TreeNode> queue = new LinkedList<>();

        Deque<TreeNode> nextQueue = new LinkedList<>();

        queue.offerLast(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.pollLast();
            layer.add(node.val);
            if(flag==0){
                if(node.left!=null){
                    nextQueue.offerLast(node.left);
                }
                if(node.right!=null){
                    nextQueue.offerLast(node.right);
                }
            }
            else{
                if(node.right!=null){
                    nextQueue.offerLast(node.right);
                }
                if(node.left!=null){
                    nextQueue.offerLast(node.left);

                }
            }
            if(queue.isEmpty()){
                Deque<TreeNode> temp = nextQueue;
                nextQueue = queue;
                queue = temp;

                flag = 1- flag;

                lists.add(layer);

                layer = new LinkedList<>();
            }
        }
        return lists;

    }

    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.offerLast("111");
        deque.offerLast("222");
        System.out.println(deque.pollFirst());
    }
}



