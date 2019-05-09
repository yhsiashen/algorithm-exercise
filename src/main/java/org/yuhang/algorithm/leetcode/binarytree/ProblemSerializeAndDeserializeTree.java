package org.yuhang.algorithm.leetcode.binarytree;


import java.util.*;

/**
 * 设计序列化和反序列化二叉树算法  297
 */
public class ProblemSerializeAndDeserializeTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    // Encodes a tree to a single string.
    // BFS
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if(root == null){
            stringBuilder.append("null]");
            return stringBuilder.toString();
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            TreeNode first = deque.poll();
            if(first == null){
                stringBuilder.append("null").append(",");
            }else {
                stringBuilder.append(first.val).append(",");
            }
            if(first!=null) {
                deque.add(first.left);
                deque.add(first.right);
            }

        }
        stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    // BFS
    public TreeNode deserialize(String data) {
        if(data == null || data.length()==0) return null;
        String dataStr = data.substring(1,data.length()-1);
        String[] nodeDatas = dataStr.split(",");
        if(nodeDatas[0].equals("null")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodeDatas[0]));
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        int i = 1;
        //重建二叉树
        while (!deque.isEmpty()){
            TreeNode first = deque.poll();
            if(i < nodeDatas.length){ //连接左子树
                if(nodeDatas[i].equals("null")){
                    i++;
                }
                else{
                    first.left = new TreeNode(Integer.parseInt(nodeDatas[i++]));
                    deque.offer(first.left);
                }
            }

            if(i < nodeDatas.length){ //连接右子树
                if(nodeDatas[i].equals("null")){
                    i++;
                }else{
                    first.right = new TreeNode(Integer.parseInt(nodeDatas[i++]));
                    deque.offer(first.right);
                }
            }
        }
        return root;
    }

    // Encodes a tree to a single string.
    // Recursion
    public String serialize1(TreeNode root) {
        if(root == null){
            return "null,";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(",");
        sb.append(serialize1(root.left));
        sb.append(serialize1(root.right));
        return sb.toString();
    }


    // Decodes your encoded data to tree.
    // Recursion
    public TreeNode deserialize1(String data) {
        String[] strarr = data.split(",");
        Queue<String> queue = new ArrayDeque<>(Arrays.asList(strarr));
        return deserializeByRecur(queue);
    }

    private TreeNode deserializeByRecur(Queue<String> queue) {
        String string = queue.remove();
        if ("null".equals(string)) {
            return null;
        }
        TreeNode newNode = new TreeNode(Integer.parseInt(string));
        newNode.left = deserializeByRecur(queue);
        newNode.right = deserializeByRecur(queue);
        return newNode;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        ProblemSerializeAndDeserializeTree p = new ProblemSerializeAndDeserializeTree();
        p.deserialize1(p.serialize1(root));


    }
}
