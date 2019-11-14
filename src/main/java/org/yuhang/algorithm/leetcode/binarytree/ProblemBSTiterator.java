package org.yuhang.algorithm.leetcode.binarytree;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 实现一个二叉搜索树迭代器 LC173  时间复杂度O(1),空间复杂度O(h)-h为二叉树高度
 */
public class ProblemBSTiterator {


    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    class BSTIterator {


        Deque<TreeNode> deque = new ArrayDeque<>();

        public BSTIterator(TreeNode root) {
           initDeque(root);
        }

        private void initDeque(TreeNode root){
            while (root!=null){ //将root的左子树链压入队列中
                deque.add(root);
                root = root.left;
            }
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            TreeNode cur = deque.pollLast();
            int res = cur.val;
            if(cur.right!=null){
                cur = cur.right;
                while (cur!=null){//将右子树的左子树链压入队列中
                    deque.add(cur);
                    cur = cur.left;
                }
            }
            return res;
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !deque.isEmpty();
        }
    }
}
