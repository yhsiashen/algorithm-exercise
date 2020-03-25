package org.yuhang.algorithm.interview;

import java.util.Stack;

/**
 * 将二叉搜索树转换为排序的双向循环链表
 *
 */
public class ProblemConvertBinaryTreeToSortedDoublyLinkedlist {

  // Definition for a Node.
   static class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
   }

   Node pre;
   Node head,tail;

    /**
     * 递归
     * @param root
     * @return
     */
   public Node treeToDoublyList(Node root) {
         if(root == null) return null;
         recur(root);
         head.left = tail;
         tail.right = head;
         return head;
   }

    private void recur(Node root) {
       if(root == null) return;
       recur(root.left);
       root.left = pre;
       if(pre == null){
           head = root;
       }else{
           pre.right = root;
       }
       pre = root;
       tail = root;
       recur(root.right);
    }

    /**
     * 迭代-用栈模拟递归
     * @param root
     * @return
     */
    public Node treeToDoublyList1(Node root) {
        if(root == null) return null;
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node head=null,pre=null,tail=null;
        while (!stack.isEmpty() || cur!=null) {
            while (cur!= null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur.left = pre;
            if(pre ==null){//处理头结点
                head = cur;
            }else{
                pre.right = cur;
            }
            pre = cur;
            tail = cur;
            cur = cur.right;
        }
        head.left = tail;
        tail.right = head;
        return head;
    }

    public static void main(String[] args) {
        Node root= new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(5);
        new ProblemConvertBinaryTreeToSortedDoublyLinkedlist().treeToDoublyList1(root);

    }

}
