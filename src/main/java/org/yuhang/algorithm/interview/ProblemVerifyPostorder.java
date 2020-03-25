package org.yuhang.algorithm.interview;

import java.util.Stack;

/**
 * 二叉搜索树的后序遍历序列
 */
public class ProblemVerifyPostorder {

    /**
     * 递归
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        if(postorder.length == 0) return true;
        return verify(postorder,0,postorder.length-1);
    }

    private boolean verify(int[] postorder, int start, int end) {
        if(start <0 || end>=postorder.length || start >= end) return true;
        int root = postorder[end];
        int post = -1;//右子树开始位置
        for (int i = start; i <end ; i++) {
            if(postorder[i] > root && post == -1) post = i;
            if(postorder[i] < root && post != -1) return false;
        }
        if(post == -1) post = end;//若没有右子树
        return verify(postorder,start,post-1) &&
                 verify(postorder,post,end-1);
    }

    /**
     * 单调栈
     * @param postorder
     * @return
     */
    public boolean verifyPostorder1(int[] postorder) {
        if(postorder.length == 0) return true;
        Stack<Integer> stack = new Stack<>();
        int preElem = Integer.MAX_VALUE;
        //逆序遍历后序序列，即 根->右->左。 由二叉搜索树的性质：左<根<右，用一个单调递增栈保存根和右子树的值，遇到左子树的值时将之前的右子树和根全弹出来
        for (int i = postorder.length-1; i >=0 ; i--) {
            if(postorder[i] > preElem) return false;
            while (!stack.isEmpty() && postorder[i] < stack.peek()){
                preElem = stack.pop();
            }
            stack.push(postorder[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] postorder = {7,6,5,4};
        System.out.println(new ProblemVerifyPostorder().verifyPostorder(postorder));
    }
}
