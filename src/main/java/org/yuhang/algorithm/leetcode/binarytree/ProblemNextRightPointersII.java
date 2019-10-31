package org.yuhang.algorithm.leetcode.binarytree;

/**
 * 填充每一个节点的下一个右侧节点指针II LC117
 */
public class ProblemNextRightPointersII {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }
    }

    public Node connect(Node root) {
       if(root == null) return null;
       if(root.left!=null){ //填充root左子树的next指针
           if(root.right!=null){
               root.left.next = root.right;
           }else{
               if(root.next!=null && root.next.left!=null){
                   root.left.next = root.next.left;
               }else if(root.next!=null && root.next.right!=null){
                   root.left.next = root.next.right;
               }
           }
       }

       if(root.right!=null){ //填充root右子树的next指针
           if(root.next!=null && root.next.left!=null){
               root.right.next = root.next.left;
           }else if(root.next!=null && root.next.right!=null){
               root.right.next = root.next.right;
           }
       }

       if(root.left!=null) connect(root.left);
       if(root.right!=null) connect(root.right);
       return root;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.right.left = new Node(5);
        new ProblemNextRightPointersII().connect(node);

    }

}
