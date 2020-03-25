package org.yuhang.algorithm.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * 深拷贝带随机指针的链表
 */
public class ProblemCopyRandomList {

     // Definition for a Node.
    static class Node {
      int val;
      Node next;
      Node random;

      public Node(int val) {
         this.val = val;
         this.next = null;
         this.random = null;
      }
    }

    Map<Node,Node> visited = new HashMap<>();//node节点与其深拷贝的映射

    public Node copyRandomList(Node head) {
        if(head==null) return null;
        if(visited.containsKey(head)){
            return visited.get(head);
        }
        Node newHead = new Node(head.val);
        visited.put(head,newHead);
        newHead.random = copyRandomList(head.random);
        newHead.next = copyRandomList(head.next);
        return newHead;
    }

    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.random = head;
        new ProblemCopyRandomList().copyRandomList(head);
    }
}
