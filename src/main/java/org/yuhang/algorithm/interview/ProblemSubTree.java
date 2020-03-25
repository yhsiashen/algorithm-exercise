package org.yuhang.algorithm.interview;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 判断B是否为A的子结构
 */
public class ProblemSubTree {

     // Definition for a binary tree node.
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    /**
     * 判断B是否为A的子树
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
         if(A==null || B==null) return false;
         if(A.val == B.val){
             return isSameTree(A,B);
         }else{
             return isSubStructure(A.left,B) || isSubStructure(A.right,B);
         }
    }

    /**
     * 判断A、B是否一样
     * @param A
     * @param B
     * @return
     */
    private boolean isSameTree(TreeNode A, TreeNode B) {
          if(B == null)return true;
          if(A == null)return false;
          if(A.val == B.val){
              return isSameTree(A.left,B.left) && isSameTree(A.right,B.right);
          }else{
              return false;
          }
//        Deque<TreeNode> dequeA = new LinkedList<>();
//        Deque<TreeNode> dequeB = new LinkedList<>();
//        dequeA.offer(A);
//        dequeB.offer(B);
//        while (!dequeB.isEmpty() && !dequeA.isEmpty()){
//            int sizeA = dequeA.size();
//            int sizeB = dequeB.size();
//            if(sizeA!=sizeB) return false;
//            while (sizeA>0){
//                sizeA--;
//                TreeNode curA = dequeA.poll();
//                TreeNode curB = dequeB.poll();
//                if(curA.val!=curB.val) return false;
//                if(curB.left!=null) {
//                    dequeB.offer(curB.left);
//                    if(curA.left!=null) dequeA.offer(curA.left);
//                }
//                if(curB.right!=null) {
//                    dequeB.offer(curB.right);
//                    if(curA.right!=null) dequeA.offer(curA.right);
//                }
//            }
//        }
//
//        return dequeB.isEmpty();

    }
}
