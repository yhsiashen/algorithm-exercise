package org.yuhang.algorithm.leetcode.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/** 二叉树自底向上的层次遍历  107
 * Created by chinalife on 2018/12/4.
 */
public class ProblemLevelOrderBottom {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root ==null)
            return result;
        //临时结果表
        Deque<List<Integer>> tempResult = new LinkedList<>();
        //每层的节点值
        List<Integer> everyResult = new LinkedList<>();
        //双向队列存储该层节点
        Deque<TreeNode> treeNodeDeque = new LinkedList<>();
        //双向队列存储下层节点
        Deque<TreeNode> nextNodeDeque = new LinkedList<>();
        treeNodeDeque.offer(root);
        while (!treeNodeDeque.isEmpty()){
            TreeNode cur = treeNodeDeque.poll();
            everyResult.add(cur.val);
            if(cur.left!=null)
                nextNodeDeque.offer(cur.left);
            if(cur.right!=null)
                nextNodeDeque.offer(cur.right);
            //如果当成节点遍历完成，取下层节点
            if(treeNodeDeque.isEmpty()){
                treeNodeDeque = nextNodeDeque;
                //将下层节点队列指向一个新的空队列
                nextNodeDeque = new LinkedList<>();
                //将每层的节点值存到result队列中
                tempResult.add(everyResult);
                everyResult = new LinkedList<>();
            }
        }
        //将临时结果中的元素存到结果list中
        while (!tempResult.isEmpty())
            result.add(tempResult.pollLast());
        return result;

    }

}
