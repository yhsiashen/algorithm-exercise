package org.yuhang.algorithm.review.new20200226;

import org.yuhang.algorithm.review.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的右视图
 */
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                if(size == 1) res.add(queue.peek().val);//该层的最右元素
                TreeNode top = queue.poll();
                if(top.left!=null) queue.offer(top.left);
                if(top.right!=null) queue.offer(top.right);
                size--;
            }
        }
        return  res;
    }
}
