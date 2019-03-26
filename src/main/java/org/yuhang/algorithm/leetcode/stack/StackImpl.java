package org.yuhang.algorithm.leetcode.stack;

/**
 * 栈的各种实现
 */
public class StackImpl {


    /**
     * 链表节点定义
     */
    public static class Node{
        public int data;
        public Node next;
        public Node(int data){
            this.data = data;
        }
    }

    /**
     * 数组实现栈
     */
    public static class ArrayStack{

        private int[] element;
        /** 栈容量*/
        private int capacity;
        /** 栈顶指针*/
        private int top=-1;
        /** 默认容量*/
        private static int DEFAULT_CAPACITY=10;
        public ArrayStack(){
            this.capacity = DEFAULT_CAPACITY;
            this.element = new int[DEFAULT_CAPACITY];
        }

        public ArrayStack(int capacity){
            this.capacity = capacity;
            this.element = new int[capacity];
        }

        /**
         * 入栈
         * @param val
         */
        public boolean push(int val){
            if(top  >=  capacity-1)
                throw new ArrayIndexOutOfBoundsException("stack capacity is full");
            //先变指针，再赋值
            element[++top] = val;
            return true;
        }

        /**
         * 弹出栈顶元素
         * @return
         */
        public int pop(){
            if(top<0){
                throw new ArrayIndexOutOfBoundsException("stack is empty");
            }
            return element[top--];
        }
    }

    /**
     * 链表实现栈(有界)
     */
    public static class LinkedStack{

        private Node head;
        /** 栈容量*/
        private int capacity;
        /** 栈顶指针*/
        private int top=0;
        /** 默认容量*/
        private static int DEFAULT_CAPACITY=10;

        public LinkedStack(){
            this.capacity = DEFAULT_CAPACITY;
        }

        public LinkedStack(int capacity){
            this.capacity = capacity;
        }

        /**
         * 入栈
         * @param val
         * @return
         */
        public boolean push(int val) {
            //若栈满了,则抛异常
            if(top >= capacity)
                throw new ArrayIndexOutOfBoundsException("stack capacity is full");
            //若链表为空(top为-1时)
            if(top == -1){
                head = new Node(val);
                top++;
                return true;
            }
            //若链表不为空
            Node p = head;
            for (int i = 1; i < top; i++) {
                p = p.next;
            }
            p.next = new Node(val);
            top++;
            return true;
        }

        /**
         * 弹出栈顶元素
         * @return
         */
        public int pop(){
            //若栈为空，则抛异常
            if(top == 0)
                throw new ArrayIndexOutOfBoundsException("stack is empty");
            Node p = head;
            //找到倒数第二个元素
            for (int i = 1; i < top-1; i++) {
                p = p.next;
            }
            int val = p.next.data;
            p.next = null;
            return val;
        }
    }

}
