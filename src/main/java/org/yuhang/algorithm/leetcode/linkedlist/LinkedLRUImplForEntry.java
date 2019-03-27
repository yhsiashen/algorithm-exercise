package org.yuhang.algorithm.leetcode.linkedlist;

/**
 * 链表实现LRU缓存,最近最少使用元素淘汰,
 * get代表使用一次,get到元素则将此元素提到队头，
 * add元素时,删除队尾的超出容量元素
 * LRU队列里的节点是键值对(entry)
 * @param <K,V>
 */
public class LinkedLRUImplForEntry<K,V> {


    /**链表头结点定义 */
    private Node<K,V> head;

    /**队尾指针，代表链表目前长度*/
    private int tail= 0;

    /**LRU缓存队列容量*/
    private int capacity;

    /**默认缓存容量*/
    private static int DEFAULT_CAPACITY = 10;

    public LinkedLRUImplForEntry(){ this.capacity = DEFAULT_CAPACITY; }

    public LinkedLRUImplForEntry(int capacity){ this.capacity = capacity; }


    /**
     * 向LRU队列中添加元素，若容量没满，则直接添加到tail，若满了，则把head的元素删除，新加元素到tail
     * @param key,value
     */
    public void add(K key ,V value){
        //查找是否有key相同的节点，有则先删除相同的节点
        findAndRemoveIdentityEle(key);
        //若队列满了，则移除队头元素后新加元素
        if(isFull()){
          removeHeadElement();
          addTailElement(key,value);
          return;
        }
        addTailElement(key,value);
    }

    /**
     * 找到K相同的节点并返回value，并将此节点移到队尾,找不到则返回null
     * @param key
     */
    public Object get(K key){
        if(isEmpty())
            return null;
        V res =  (V)findAndRemoveIdentityEle(key);
        //添加到队尾
        addTailElement(key,res);
        return res;
    }

    /**
     * 遍历链表，若找到key相同的元素,则删除此元素
     * @param key
     */
    private Object findAndRemoveIdentityEle(K key){
        if (head!=null){
            Node p = head;
            Object vaule =null;
            //头结点是否相同,相同则删除
            if(p.entry.key.equals(key)){
                vaule = p.entry.value;
                head = p.next;
                p.next=null; //help gc
                tail--;
                return vaule;
            }
            //头节点不相同,则从第二个节点开始遍历,找到相同节点
            while (p.next!=null){
                //找到key相同的节点
                if(p.next.entry.key.equals(key)){
                    vaule = p.next.entry.value;
                    Node pnext = p.next;
                    p.next = pnext.next;
                    pnext.next=null;//help gc
                    tail--;
                }
                p=p.next;
            }
            return vaule;
        }
        return null;
    }

    /**
     * 淘汰队头节点
     */
    private void removeHeadElement(){
        if(head!=null) {
            Node p = head;
            head = p.next;
            p.next = null; //help gc
            tail--;
        }
    }

    /**
     * 添加节点到队尾
     */
    private void addTailElement(K key,V value){
        if(isEmpty()) {
            head = new Node<>(new Entry<>(key, value));
            tail++;
            return;
        }

        Node p = head;

        //找到尾节点
        while (p.next!=null){
            p = p.next;
        }
        //在队尾加节点
        p.next = new Node(new Entry(key,value));
        //链表长度+1
        tail++;
    }



    public boolean isEmpty(){
        return tail == 0;
    }

    public boolean isFull(){
        return tail>=capacity;
    }

    @Override
    public String toString() {
        Node p = head;
        StringBuilder sb = new StringBuilder();
        while (p!=null){
            sb.append(p.entry.key+"->"+p.entry.value+";");
            p = p.next;
        }

        return sb.toString();
    }

    /**
     * 链表节点定义
     * @param <K,V>
     */
    private class Node<K,V>{
        private Entry<K,V> entry;
        private Node next;

        public Node(Entry<K,V> entry){
            this.entry = entry;
        }
    }

    /**
     * 键值对定义
     * @param <K>
     * @param <V>
     */
    private class Entry<K,V>{
        private K key;
        private V value;

        public Entry(K key,V value){
            this.key = key;
            this.value = value;
        }

    }


    public static void main(String[] args) {
        LinkedLRUImplForEntry<String ,String> lru = new LinkedLRUImplForEntry<>(3);
        lru.add("yuhang","yu1");
        lru.add("xiaoming","xi1");
        lru.add("zhaosan","zh1");
        lru.add("lisi","li1");
//        lru.add("zhaosan","zh2");
        System.out.println(lru.toString());
        System.out.println(lru.get("xiaoming"));
        System.out.println(lru.toString());
    }
}
