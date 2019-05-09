package org.yuhang.algorithm.leetcode.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 填充二叉树节点的下一个右侧节点指针 116
 */
public class ProblemNextRightPointers {

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     * 方法1: 计算当前节点是否是这一层的最后一个节点
     * @param root
     * @return
     */
    public Node connect1(Node root) {
        if (root == null) return null;
        Deque<Node> deque = new LinkedList<>();
        deque.add(root);
        int i = 0; //表示下标
        int level = 1; //表示层数
        while (!deque.isEmpty()) {
            Node first = deque.poll();
            i++;
            if (i + 1 == Math.pow(2, level)) { //一层结束
                level++;
                if (first.left != null) deque.add(first.left);
                if (first.right != null) deque.add(first.right);
                continue;
            }
            first.next = deque.peek(); //将该节点的next指向目前队列头节点
            if (first.left != null) deque.add(first.left);
            if (first.right != null) deque.add(first.right);
        }
        return root;
    }

    /**
     * 方法2：节点的左子树的next指针必然指向节点的右子树
     *       节点的右子树的next指针根据父节点的next指针是否为空判断
     * @param root
     * @return
     */
    public Node connect2(Node root){
         if(root == null) return null;
         if(root.left!=null) root.left.next = root.right; //root的左子树的next必然指向root的右子树
         if(root.right!=null && root.next != null) root.right.next = root.next.left;//root的右子树的next根据父节点的next指针判断

         connect2(root.left); //左子树填充next指针
         connect2(root.right); //右子树填充next指针
         return root;
    }
}
