package org.yuhang.algorithm.leetcode.design;

import java.util.HashMap;

/**
 * 设计LFU缓存
 */
public class LFUCache {

    /**
     * 双向链表节点定义
     */
    class DLinkedNode{
        int key;
        int val;
        int count;//get和put此元素的次数
        DLinkedNode pre;
        DLinkedNode next;

        public DLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.count = 1; //初始化的时候已经被put了一次了
        }
    }

    /**
     * 双向链表定义
     */
    class DLinkedList{
        DLinkedNode head;
        DLinkedNode tail;

        public DLinkedList() {
            this.head = new DLinkedNode(-1,-1);
            this.tail = new DLinkedNode(-1,-1);
            head.next = tail;
            tail.pre = head;
        }
    }

    int size;
    int capacity;
    int minFreqs;
    HashMap<Integer, DLinkedNode> cache;//在O(1)时间内，根据key查到value
    HashMap<Integer, DLinkedList> freqs;//在O(1)时间内，维护频次与key-value的关系


    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.freqs = new HashMap<>();
    }

    public int get(int key) {
        if(capacity == 0) return -1;
        DLinkedNode node = cache.get(key);
        if(node == null) return -1;//不存在返回-1
        removeLinkedNode(node);
        node.count++;
        addLinkedNodeToFreqs(node);
        return node.val;
    }

    /**
     * 将node添加到freqs中对应频次的双向链表的头部中
     * @param node
     */
    private void addLinkedNodeToFreqs(DLinkedNode node) {
        DLinkedList doubleLinkedList = freqs.getOrDefault(node.count, new DLinkedList());
        node.next = doubleLinkedList.head.next;
        doubleLinkedList.head.next = node;
        node.pre = doubleLinkedList.head;
        node.next.pre = node;
        freqs.put(node.count, doubleLinkedList);
    }

    /**
     * 将node从原来频次的双向链表中剥离
     * @param node
     */
    private void removeLinkedNode(DLinkedNode node) {
        DLinkedList doubleLinkedList = freqs.get(node.count);

        DLinkedNode pre = node.pre;
        DLinkedNode next = node.next;
        pre.next = next;
        next.pre = pre;

        node.pre = null;
        node.next = null;

        //如果此频次对应的双向链表没有节点了，且最小频次是此双向链表，则维护最小频次+1
        if(minFreqs == node.count && doubleLinkedList.head.next == doubleLinkedList.tail){
            minFreqs++;
        }
    }


    public void put(int key, int value) {
        if(capacity == 0) return;
        DLinkedNode dLinkedNode = cache.get(key);
        if(dLinkedNode != null){//修改原有缓存
            dLinkedNode.val = value;
            removeLinkedNode(dLinkedNode);//移除原有频次
            dLinkedNode.count++;
            addLinkedNodeToFreqs(dLinkedNode);//加入新频次的hash槽位
        }else {//新添加缓存
            dLinkedNode = new DLinkedNode(key, value);
            if (size >= capacity) {//如果已达到缓存容量，则先淘汰最少使用次数的缓存
                removeLeastFreqsNode();
                size--;
            }
            addLinkedNodeToFreqs(dLinkedNode);
            size++;//size+1
            minFreqs = 1;//新加入一个缓存后，最少的使用频次为1
            cache.put(key, dLinkedNode);
        }
    }

    /**
     * 淘汰使用频次最少的节点,若有多个节点频次使用一样，则淘汰最近最少使用节点
     */
    private void removeLeastFreqsNode(){
        DLinkedList minFreqsDoubleLinedList = freqs.get(minFreqs);
        DLinkedNode minFreqsNode = minFreqsDoubleLinedList.tail.pre;
        DLinkedNode pre = minFreqsNode.pre;
        pre.next = minFreqsDoubleLinedList.tail;
        minFreqsDoubleLinedList.tail.pre = pre;
        minFreqsNode.pre = null;
        minFreqsNode.next = null;

        cache.remove(minFreqsNode.key);//从cache中移除节点
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3, 3);    // 去除 key 2
        System.out.println(cache.get(2));       // 返回 -1 (未找到key 2)
        System.out.println(cache.get(3));       // 返回 3
        cache.put(4, 4);    // 去除 key 1
        System.out.println(cache.get(1));       // 返回 -1 (未找到 key 1)
        System.out.println(cache.get(3));       // 返回 3
        System.out.println(cache.get(4));       // 返回 4

    }

}
