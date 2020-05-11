package org.yuhang.algorithm.review;

import java.util.HashMap;

/**
 * 设计LRU缓存
 */
public class LRUCache {

    class Node{
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DoubleLinkedList{

        Node head;
        Node tail;

        public DoubleLinkedList() {
            this.head = new Node(-1,-1);
            this.tail = new Node(-1,-1);
            head.next = tail;
            tail.pre = head;
        }
    }

    private HashMap<Integer,Node> map;

    private DoubleLinkedList doubleLinkedList;

    private int capacity;

    private int size;

    private boolean isFull(){
        return size == capacity;
    }

    private boolean isEmpty(){
        return size == 0;
    }

    public LRUCache(int capacity) {
        this.map = new HashMap<>(capacity);
        this.doubleLinkedList = new DoubleLinkedList();
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        removeNodeFromList(node);
        addHead(node);
        return node.value;
    }


    /**
     * 在链表头部新增一个节点
     */
    private void addHead(Node newNode) {
        Node p = doubleLinkedList.head;
        newNode.next = p.next;
        p.next.pre = newNode;
        p.next = newNode;
        newNode.pre = p;
    }

    /**
     * 在双向链表中删除指定节点
     * @param remove
     */
    private void removeNodeFromList(Node remove) {
        Node pre = remove.pre;
        Node next = remove.next;
        pre.next = next;
        next.pre = pre;
        remove.pre = null;
        remove.next = null;
    }

    public void put(int key, int value) {
        if(!map.containsKey(key)){
            if(isFull()){
                int removeKey = removeTailFromList();
                map.remove(removeKey);
                size--;
            }
            Node newNode = new Node(key,value);
            map.put(key,newNode);
            addHead(newNode);
            size++;
        }else{
            Node node = map.get(key);
            node.value = value;
            removeNodeFromList(node);
            addHead(node);

        }
    }

    /**
     * 删除链表尾部的节点
     */
    private int removeTailFromList() {
        Node last = doubleLinkedList.tail.pre;
        Node pre = last.pre;
        pre.next = last.next;
        last.next.pre = pre;
        last.pre = null;
        last.next = null;
        return last.key;
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
