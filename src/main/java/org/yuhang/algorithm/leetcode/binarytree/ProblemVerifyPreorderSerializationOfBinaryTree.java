package org.yuhang.algorithm.leetcode.binarytree;


import java.util.Stack;

/**
 * 验证二叉树的前序序列化 LC331
 * 思想:二叉树的叶子节点总是比非叶子节点多1个
 * @tag:二叉树
 */
public class ProblemVerifyPreorderSerializationOfBinaryTree {


    public boolean isValidSerialization(String preorder) {
        if(preorder.length() == 0) return false;
        if(preorder.length() == 1) return "#".equals(preorder);
        if(preorder.charAt(preorder.length()-1)!='#')return false;
        Stack<Character> stack = new Stack<>();
        preorder = preorder.substring(0,preorder.length()-2);
        for (int i = 0; i < preorder.length(); i++) {
            char ch = preorder.charAt(i);
            if(ch!=',') {
                if (ch == '#') {
                    if (stack.isEmpty()) {
                        return false;
                    } else {
                        stack.pop();
                    }
                } else {
                    while (i<preorder.length()-1 && Character.isDigit(preorder.charAt(i))){
                        i++;
                    }
                    stack.push(ch);
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new ProblemVerifyPreorderSerializationOfBinaryTree().isValidSerialization("9,#,92,#,#"));
    }

}
