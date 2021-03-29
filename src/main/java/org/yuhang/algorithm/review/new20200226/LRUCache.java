package org.yuhang.algorithm.review.new20200226;

import java.util.HashMap;
import java.util.Map;

/**
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // 返回  1
 * cache.put(3, 3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4, 4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 *
 */
public class LRUCache {


    int capacity;

    int size;

    Node head;

    Node tail;

    HashMap<Integer,Integer> map;


    public LRUCache(int capacity) {
        if(capacity <= 0) throw new IllegalArgumentException("capacity should be a positive number");
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if(isEmpty() || !map.containsKey(key)) return -1;
        int value = map.get(key);
        afterNodeAccess(key);
        return value;
    }

    //某元素被访问后，将该元素节点移到链表尾部
    private void afterNodeAccess(int key){
        Node h = head;
        Node t = tail;
        while (h!=null){
            if(key == h.key){
               if(h == head){//h是头节点
                   head = h.next;
                   h.next = null;
                   tail.next = h;
                   h.pre = tail;
               }else{//h是中间节点

               }

            }else{
                h = h.next;
            }
        }
    }

    public void put(int key, int value) {

    }

    private boolean isEmpty(){
        return size == 0;
    }

    private boolean isFull(){
        return size == capacity;
    }



    private class Node {
        int key;
        int value;
        Node next;
        Node pre;

        public Node(){}

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}
