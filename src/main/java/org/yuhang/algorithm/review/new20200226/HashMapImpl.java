package org.yuhang.algorithm.review.new20200226;

/**
 * hashmap实现
 */
public class HashMapImpl<K,V> {


    Node<K,V>[] table;

    int capacity;

    int count;

    float loadFactor = 0.75f;

    float threshold = 12;

    static final int MAXIMUM_CAPACITY = 1 << 30;


    public HashMapImpl(){
        this.capacity = 16;
        table = new Node[16];
    }

    public HashMapImpl(int capacity){
       this.capacity = capacity;
       table = new Node[capacity];
       this.threshold =capacity*loadFactor;
    }

    public HashMapImpl(int capacity,int loadFactor){
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.threshold = capacity*loadFactor;
    }

    private static int tableSizeFor(int cap) {
//        int n = cap - 1;
//        n |= n >>> 1;
//        n |= n >>> 2;
//        n |= n >>> 4;
//        n |= n >>> 8;
//        n |= n >>> 16;
//        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
        //找到离cap最近且大于等于cap的2的次幂数
        int n = 1;
        while (Math.pow(2, n) < cap && Math.pow(2, n) >= MAXIMUM_CAPACITY){
            n++;
        }
        return (int)Math.pow(2, n);
    }

    private int length(){
        return table.length;
    }

    private int size(){
        return count;
    }

    private int hash(K key){
        int hashCode = key.hashCode();
        //将hashCode与hashCode右移16位后做异或
        return hashCode ^ (hashCode >>> 16);
    }

    public V put(K key,V value){
        //hashmap允许key和value为null， hashtable则不行
//        if(key == null || value == null) {
//            throw new IllegalArgumentException("key or value must not be null");
//        }
        int hash = hash(key);
        Node<K,V> node = table[hash % length()];
        if(node == null){
            node = new Node<>(key, value, hash);
            table[hash & (length()-1)] = node;
            count++;
        }else if(hash == node.hash && (key == node.key || key.equals(node.key))){
            node.value = value;
        }else{
            while (node.next!=null){
                if(key == node.key || key.equals(node.key)){
                    node.value = value;
                    break;
                }
                node = node.next;
            }
            if(hash == node.hash && (key == node.key || key.equals(node.key))){
                node.value = value;
            }else{
                node.next = new Node<>(key,value,hash);
                count++;
            }
        }

        //如果map中的节点数目大于阈值，则扩容
        if(count > threshold){
            resize();
        }

        return node.value;
    }

    public V get(K key){
        int hash = hash(key);
        Node<K,V> node = table[hash & (length()-1)];
        if(node == null){
            return null;
        }else if(key == node.key || key.equals(node.key)){
            return node.value;
        }else{
            while (node!=null){
                if(key == node.key || key.equals(node.key)){
                    return node.value;
                }
                node = node.next;
            }
        }
        return null;
    }


    /**
     * 扩容，容量扩大为2倍
     */
    private void resize(){
        int newCapacity = capacity << 1;
        Node<K,V>[] newTable = new Node[newCapacity];
        Node<K,V>[] oldTable = table;
        //遍历原数组和数组槽位的链表，重新计算Hash值后加入新数组
        for(int i=0;i < oldTable.length;i++){
            Node<K,V> e = oldTable[i];
            oldTable[i] = null;//原数组引用置空
            //遍历链表e，将所有节点加入新数组中
            while (e!=null){
                Node<K,V> next=  e.next;
                int index = e.hash & (newCapacity -1);
                e.next = newTable[index];
                newTable[index] = e;
                e = next;
            }
        }
        table = newTable;
        threshold = newCapacity * loadFactor;//修改阈值
    }


    private class Node<K,V>{
        int hash;
        K key;
        V value;
        Node next;

        public Node(K key,V value){
            this.key = key;
            this.value = value;
        }

        public Node(K key,V value, int hash){
            this.key = key;
            this.value = value;
            this.hash = hash;
        }
    }

    public static void main(String[] args) {
        HashMapImpl map = new HashMapImpl();
        map.put("1","hak");
        map.put("2", "7ha");
        map.put("3","klo");
        map.put("4","4");
        map.put("5","4");
        map.put("6","4");
        map.put("7","4");
        map.put("8","4");
        map.put("9","4");
        map.put("10","4");
        map.put("11","4");
        map.put("12","4");
        map.put("13","4");
        map.put("14","4");
        map.put("15","4");
        map.put("16","4");
        map.put("adj9o","4");
        map.put("adj","4");
        map.put("9iaj","4");
        map.put("kk","4");
        map.put("23e","4");
        map.put("adzc","4");

        System.out.println(map.size());
        System.out.println(map.length());
        System.out.println(-Integer.MIN_VALUE);
    }





}
