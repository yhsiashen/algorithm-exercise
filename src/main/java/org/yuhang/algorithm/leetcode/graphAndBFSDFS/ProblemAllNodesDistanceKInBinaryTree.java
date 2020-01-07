package org.yuhang.algorithm.leetcode.graphAndBFSDFS;

import java.util.*;

/**
 * 二叉树中所有距离为K的节点 LC863
 */
public class ProblemAllNodesDistanceKInBinaryTree {


     //Definition for a binary tree node.
     public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    /**
     * dfs,注意不要走不合要求的路径
     * @param root
     * @param target
     * @param K
     * @return
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
          Set<Integer> res = new HashSet<>();
          if(root == null) return new ArrayList<>(res);
          if(K == 0) {
              res.add(target.val);
              return new ArrayList<>(res);
          }
          Map<TreeNode,TreeNode> parentMap = new HashMap<>();
          constructParent(parentMap,root);//构建父节点引用的图
          int targetVal = target.val;
          TreeNode t = target;
          TreeNode parent = null;
          int K1 = K;
          int flag = 0;// 表示dfs找子树时能往哪边找，0-都可以，-1-能找左边，1-能找右边
          while (K1>0){  //往上找父节点离target为K距离的节点
              parent =  parentMap.get(t);
              if(parent!=null && parent.left == t){
                  flag = 1;
              }else if(parent!=null && parent.right == t){
                  flag = -1;
              }
              dfs(res,parent,K1-1,targetVal,flag);//往父节点的下面找
              t = parent; //继续往上找
              K1--;
          }
          if(parent!=null) res.add(parent.val);
          //找子节点距target为K距离的节点
          dfs(res,target,K,targetVal,0);
          return new ArrayList<>(res);

    }

    private void dfs(Set<Integer> res, TreeNode node, int k, int target,int flag) {
         if(node==null) return;
         if(k == 0){
             if(target!= node.val) res.add(node.val);
             return;
         }
         if(flag!=1)  dfs(res,node.left,k-1,target,0);
         if(flag!=-1) dfs(res,node.right,k-1,target,0);

    }

    private void constructParent(Map<TreeNode,TreeNode> parentMap, TreeNode root){
         if(root == null) return;
         if(root.left!=null) {
             parentMap.put(root.left,root);
             constructParent(parentMap,root.left);
         }

         if(root.right!=null){
             parentMap.put(root.right,root);
             constructParent(parentMap,root.right);
         }
    }

    public static void main(String[] args) {
        ProblemAllNodesDistanceKInBinaryTree p = new ProblemAllNodesDistanceKInBinaryTree();
        TreeNode node = new TreeNode(0);
        node.left = new TreeNode(2);
        node.right = new TreeNode(1);
//        node.left.left = new TreeNode(6);
//        node.left.right = new TreeNode(2);
        node.right.left = new TreeNode(3);
//        node.right.right = new TreeNode(8);
//        node.left.right.left = new TreeNode(7);
//        node.left.right.right = new TreeNode(4);
        p.distanceK(node,node.right.left,3);
    }

}
