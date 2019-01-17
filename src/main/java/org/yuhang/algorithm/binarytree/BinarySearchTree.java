package org.yuhang.algorithm.binarytree;

import java.util.Stack;

/** 二叉搜索树
 * Created by yuhang on 2018/3/20.
 */
public class  BinarySearchTree extends Node {
    public Node root;

    //构造根节点为root的二叉搜索树
    public BinarySearchTree(Node root){
        this.root = root;
    }

    //二叉搜索树插入一个节点
    public void insertNode(int i){
        //如果根节点为空，则作为根节点
        if(root == null){
            root = new Node(i);
        }
        Node current = root;
        while (true){
            // 插入的数据i比根节点的数据小，进入左子树
            if(i<=current.data){
                //如果左子树不为空，将根节点置为左节点，继续循环;为空，则插入
                if(current.left!=null){
                    current = current.left;
                }else{
                    current.left = new Node(i);
                    break;
                }
            // 插入的数据i比根节点的数据大，进入右子树
            }else {
                if(current.right!=null){
                    current = current.right;
                }else {
                    current.right = new Node(i);
                    break;
                }
            }
        }
    }

    //二叉搜索树查找一个节点
    public void searchNode(int i){
         Node current = root;
         while (true) {
             // 小于根节点，进入左子树
             if (i < root.data) {
                 if (current!=null){
                     current = current.left;
                 }else {
                     System.out.println("查找的节点不存在");
                     break;
                 }
              // 大于根节点，
             }else if(i > root.data){
                 if(current!=null){
                     current = current.right;
                 }else{
                     System.out.println("查找的节点不存在");
                 }
             }else {
                 System.out.println("查找的节点为:"+current.data);
             }
         }
    }

    //中序遍历二叉搜索树得到有序排列(递归法)  左→根→右
    public void printTreeByRec(Node root){
        if(root.left!=null){
            printTree(root.left);
        }
        System.out.println(root.data);
        if(root.right!=null){
            printTree(root.right);
        }
    }

    //中序遍历二叉搜索树得到有序排列(非递归法)
    public void printTree(Node root){
        //构造一个空栈
        Stack<Node> stack = new Stack<Node>();
        //将根节点入栈
        stack.push(root);
        Node current;
        while (!stack.isEmpty()){
            current = stack.peek();
            if(current.state == 0){
                if(current.left!=null){
                    stack.push(current.left);
                }
                current.state = 1;

            }else if(current.state == 1 ){
                System.out.println(current.data);
                current.state = 2;
            }else if(current.state == 2){
                if(current.right !=null){
                    stack.push(current.right);
                }
                current.state = 3;
            }else {
                stack.pop();
                current.state = 0;
            }
        }

    }

    public static void main(String[] args) {
        Node root = new Node(5);
        BinarySearchTree BST = new BinarySearchTree(root);
        BST.insertNode(3);
        BST.insertNode(10);
        BST.insertNode(0);
        BST.insertNode(2);
        BST.insertNode(4);
        BST.insertNode(8);
        BST.printTree(BST.root);

    }


}
