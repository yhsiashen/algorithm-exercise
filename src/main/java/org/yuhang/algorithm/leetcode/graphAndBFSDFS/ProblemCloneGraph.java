package org.yuhang.algorithm.leetcode.graphAndBFSDFS;


import java.util.*;

/**
 * 克隆图,返回给定图的深拷贝 133
 */
public class ProblemCloneGraph {

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    /**
     * DFS
     * @param node
     * @return
     */
    public Node cloneGraphByDFS(Node node){
       if(node ==null) return null;
       Map<Node,Node> map = new HashMap<>();
       return DFS(node,map);
    }

    private Node DFS(Node node, Map<Node,Node> map) {
       if(node == null) return null;
       if(map.containsKey(node)) return map.get(node);
       //深拷贝
       Node cloneNode = new Node(node.val, new ArrayList<>());
       map.put(node,cloneNode); //map存原图节点与克隆节点的映射
        for (Node neighbor:node.neighbors) {
            cloneNode.neighbors.add(DFS(neighbor,map));
        }
       return cloneNode;
    }


    /**
     * BFS
     * @param node
     * @return
     */
    public Node cloneGraphByBFS(Node node){
        if(node == null) return null;
        Deque<Node> deque = new LinkedList<>();
        deque.offer(node); //队列用于BFS
        Node cloneNode = new Node(node.val,new ArrayList<>());
        Map<Node,Node> map = new HashMap<>(); //node 与 cloneNode的映射
        map.put(node,cloneNode);
        while (!deque.isEmpty()){
            Node first = deque.poll();
            for (Node neighbor:first.neighbors) { //遍历队列first Node的所有邻居节点
                if(!map.containsKey(neighbor)){//没遍历过的节点才加入队列
                    map.put(neighbor,new Node(neighbor.val,new ArrayList<>()));
                    deque.offer(neighbor);
                }
                map.get(first).neighbors.add(map.get(neighbor));
            }
        }

        return cloneNode;
    }


}
