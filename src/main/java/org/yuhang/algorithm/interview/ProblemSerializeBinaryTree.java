package org.yuhang.algorithm.interview;

import java.util.*;

/**
 * 序列化与反序列化二叉树
 */
public class ProblemSerializeBinaryTree {


     //Definition for a binary tree node.
      static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }


    public String serializeByDFS(TreeNode root) {      //用StringBuilder
        StringBuilder res = ser_help(root, new StringBuilder());
        return res.toString();
    }

    public StringBuilder ser_help(TreeNode root, StringBuilder str){
        if(null == root){
            str.append("null,");
            return str;
        }
        str.append(root.val);
        str.append(",");
        str = ser_help(root.left, str);
        str = ser_help(root.right, str);
        return str;
    }

    public TreeNode deserializeByDFS(String data) {
        String[] str_word = data.split(",");
        List<String> list_word = new LinkedList<>(Arrays.asList(str_word));
        return deser_help(list_word);
    }

    public TreeNode deser_help(List<String> li){
        if(li.get(0).equals("null")){
            li.remove(0);
            return null;
        }
        TreeNode res = new TreeNode(Integer.valueOf(li.get(0)));
        li.remove(0);
        res.left = deser_help(li);
        res.right = deser_help(li);
        return res;
    }


    public String serializeByBFS(TreeNode root) {
          StringBuilder res = new StringBuilder();
          Deque<TreeNode> deque = new LinkedList<>();
          deque.offer(root);
          while (!deque.isEmpty()){
              TreeNode node = deque.poll();
              if(node!=null){
                  res.append(node.val).append(",");
                  deque.offer(node.left);
                  deque.offer(node.right);
              }else{
                  res.append("null,");
              }
          }
          return res.toString();
    }

    public TreeNode deserializeByBFS(String data) {
          if(data == null || "".equals(data)) return null;
          String[] datas = data.split(",");
          if(datas[0].equals("null")) return null;
          TreeNode root = new TreeNode(Integer.parseInt(datas[0]));
          Deque<TreeNode> deque = new LinkedList<>();
          deque.offer(root);
          int i = 1;
          while (!deque.isEmpty()){
              TreeNode node = deque.poll();
              if(node == null) continue;
              if(!datas[i].equals("null")) node.left = new TreeNode(Integer.parseInt(datas[i]));
              if(!datas[i+1].equals("null")) node.right = new TreeNode(Integer.parseInt(datas[i+1]));
              i += 2;
              deque.offer(node.left);
              deque.offer(node.right);
          }
          return root;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(3);
        root.right.left.right = new TreeNode(1);
        ProblemSerializeBinaryTree p = new ProblemSerializeBinaryTree();
        System.out.println(p.serializeByBFS(root));

    }
}
