package org.yuhang.algorithm.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制带随机指针的链表 LC138
 */
public class ProblemCopyListWithRandomPointer {

    // Definition for a Node.
    static class Node {
       public int val;
       public Node next;
       public Node random;

       public Node() {}

       public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
        }
    }


    Map<Node,Node> visitedMap = new HashMap<>();

    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node oldNode = head;
        Node newNode = new Node(oldNode.val,null,null);
        visitedMap.put(head,newNode);
        while (oldNode !=null ){
            newNode.random = getCloneNode(oldNode.random);
            newNode.next = getCloneNode(oldNode.next);
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return visitedMap.get(head);
    }

    private Node getCloneNode(Node node) {
        if(node!=null){
            if(!visitedMap.containsKey(node)){
                Node cloneNode = new Node(node.val,null,null);
                visitedMap.put(node,cloneNode);
                return cloneNode;
            }else {
                return visitedMap.get(node);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Node head = new Node(1,null,null);
        head.next = new Node(2,null,null);
        head.random = head.next;
        Node p =head;
        p = p.next;
        p.random = head;
        p.next = null;
        new ProblemCopyListWithRandomPointer().copyRandomList(head);
    }


}
