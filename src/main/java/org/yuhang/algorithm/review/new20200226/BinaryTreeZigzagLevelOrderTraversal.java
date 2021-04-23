package org.yuhang.algorithm.review.new20200226;

import org.yuhang.algorithm.review.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的层次遍历
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        boolean order = true;//遍历顺序，true表示从左至右
        deque.offer(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            Deque<Integer> eachDeque  = new LinkedList<>();
            while (size > 0){
                TreeNode top = deque.poll();
                if(top.left!=null) deque.offer(top.left);
                if(top.right!=null) deque.offer(top.right);
                if(order){
                    eachDeque.offer(top.val);
                }else{
                    eachDeque.offerFirst(top.val);
                }
                size--;
            }
            order = !order;
            res.add(new ArrayList<>(eachDeque));
        }

        return res;

    }
}
