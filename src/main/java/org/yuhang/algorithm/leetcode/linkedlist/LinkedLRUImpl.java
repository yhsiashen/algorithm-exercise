package org.yuhang.algorithm.leetcode.linkedlist;

/**
 * 单链表实现LRU队列
 * 队列中的元素是单个值 ,类型为 E
 */
public class LinkedLRUImpl<E> {

    /**
     * 默认容量
     */
    private static final Integer DEFAULT_CAPACITY = 10;

    /**
     * 头结点
     */
    private Node<E> head;

    /**
     * 链表长度
     */
    private Integer length;

    /**
     * 链表容量
     */
    private Integer size;

    /**
     * 无参构造器
     */
    public LinkedLRUImpl(){
        this.size = DEFAULT_CAPACITY;
        this.head = new Node<>();
        this.length = 0;
    }

    /**
     * 有参构造器
     * @param capacity
     * @return
     */
    public LinkedLRUImpl(int capacity){
        this.size = capacity;
        this.head = new Node<>();
        this.length=0;
    }

    public int size(){ return size; }

    /**
     * 添加元素
     * @param element
     * @return
     */
    public boolean add(E element){
        //找出是否有相同内容的节点存在,若有则删除
        removeIdentityEle(element);
        //链表长度已达链表容量，则先移除表头节点
       if(length>=size){
           removeFirstNode();
       }
       //若长度为0
       if(length==0){
           head.element = element;
       } else {
           //引用头结点
           Node<E> curNode = head;
           //若长度不为0,找出链表尾部节点
           for (int i = 0; i < length-1; i++) {
               curNode = curNode.nextNode;
           }
           //将新加入节点添加到尾部
           curNode.nextNode = new Node<>(element);
       }
       length++;
       return true;
    }



    /**
     * 移除链表头节点,链表长度-1
     */
    private void removeFirstNode(){
        if(head!=null) {
            Node<E> firstNode = head;
            head = head.nextNode;
            firstNode.nextNode =null;//help gc
            length--;
        }
    }

    /**
     * 遍历链表，移除相同的元素
     * @param element
     */
    private void removeIdentityEle(E element){
        Node<E> curNode = head;
        //遍历链表找出是否存在元素相同的节点
        for (int i = 0; i < length-2; i++) {
            if(element.equals(curNode.nextNode.element)){
                //将curNode.nexNode删除
                Node<E> next = curNode.nextNode;
                curNode.nextNode = curNode.nextNode.nextNode;
                next = null;//help gc
               break;
            }

        }
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       if(head!=null){
           Node p = head;
           while (p!=null){
               sb.append(p.element);
               sb.append(" ");
               p = p.nextNode;
           }
       }
       return sb.toString();
    }

    /**
     * 节点定义
     * @param <E>
     */
    private class Node<E>{
        private E element;
        private Node<E> nextNode;
        public Node(){
            this.nextNode = null;
        }
        public Node(E element){
            this.element = element;
            this.nextNode = null;
        }
        public Node(E element,Node<E> next){
            this.element = element;
            this.nextNode = next;
        }
    }

    public static void main(String[] args) {
        LinkedLRUImpl<String> queue = new LinkedLRUImpl<>(3);
        queue.add("11");
        queue.add("22");
        queue.add("33");
        queue.add("44");
        System.out.println(queue.toString());
    }
}
