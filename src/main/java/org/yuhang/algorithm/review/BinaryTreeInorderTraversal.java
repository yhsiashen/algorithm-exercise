package org.yuhang.algorithm.review;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树中序遍历 LC94
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur!=null || !stack.isEmpty()){
            while (cur!=null){//压入cur的全部左子树
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }


//        stack.push(root);
//        while (!stack.isEmpty()){
//            TreeNode node = stack.peek();
//            while (node.left!=null){//压完所有的左子树
//                stack.push(node.left);
//                node = node.left;
//            }
//            TreeNode top = stack.pop();
//            res.add(top.val);
//            if(top.right!=null){
//                stack.push(top.right);
//            }
//        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root= new TreeNode(1);
//        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        new BinaryTreeInorderTraversal().inorderTraversal(root);
    }

}
