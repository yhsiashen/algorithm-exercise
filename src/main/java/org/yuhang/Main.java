package org.yuhang;


import java.util.*;

public class Main {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }

        public TreeNode(){
        }

    }

    private static int k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//n个节点
        int[][] val = new int[n][3];
        for (int i = 0; i < n; i++) {
            val[i][0] = sc.nextInt();
            val[i][1] = sc.nextInt();
            val[i][2] = sc.nextInt();
        }

        TreeNode root = new TreeNode();
        contructTree(root,val,0);
        dfs(root);
    }

    private static void contructTree(TreeNode node,int[][] nodes, int i){
        if(i>=nodes.length) return;
        node.val = nodes[i][0];
        if(nodes[i][1]==0 && nodes[i][2]==0) {
            return;
        }
        if(nodes[i][1]!=0) {
            k++;
            node.left = new TreeNode();
            contructTree(node.left, nodes,k);//构造左子树
        }
        if(nodes[i][2]!=0) {
            k++;
            node.right = new TreeNode();
            contructTree(node.right, nodes,k);//构造右子树
        }
    }


    private static  void  dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        dfs(root.right);
        System.out.print(root.val+"#");

    }


}

