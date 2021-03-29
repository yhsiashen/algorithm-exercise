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


    int capacity;//缓存容量

    int size;//缓存大小

    Node head;//头结点

    Node tail;//尾结点

    HashMap<Integer,Node> map;//缓存


    public LRUCache(int capacity) {
        if(capacity <= 0) throw new IllegalArgumentException("capacity should be a positive number");
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;//构造头结点
        tail.pre = head;//构造尾节点
    }

    public int get(int key) {
        Node node = map.get(key);
        if(node == null) return -1;
        afterNodeAccess(node);
        return node.value;
    }

    //某元素节点被访问后，将该元素节点移到链表头部(连接到head后面)
    private void afterNodeAccess(Node node){
        //删除node节点在链表中的位置
        node.pre.next = node.next;
        node.next.pre = node.pre;
        //将node节点连接到head后面
        addHead(node);
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if(node == null){//新增节点时插入链表头部
            node = new Node(key, value);
            addHead(node);
            map.put(key, node);
            size++;
            if(size > capacity){//如果加入数据后超过了容量，则删除链表尾部的元素
                int k = deleteTailNode();
                map.remove(k);
                size--;
            }
        }else{
            node.value = value;//更新节点的值
            afterNodeAccess(node);
        }
    }

    /**
     * 删除尾部节点，并返回该节点key
     * @return
     */
    private int deleteTailNode() {
        Node t = tail.pre;
        Node pre = t.pre;
        pre.next = tail;
        tail.pre = pre;
        t.next = null;
        t.pre = null;
        return t.key;
    }

    /**
     * 将节点加入链表头部
     * @param node
     */
    private void addHead(Node node){
        Node next = head.next;
        next.pre = node;
        node.next = next;
        node.pre = head;
        head.next = node;
    }


    /**
     * 双向链表，删除节点时间复杂度为O(1)
     */
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

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4

    }
}
