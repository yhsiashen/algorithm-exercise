package org.yuhang.algorithm.jiketime;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用链表实现LRU(最近最少使用)缓存淘汰算法
 * Created by chinalife on 2018/10/8.
 */
public class LRUByListNode {

    /**
     * 链表节点定义
     */
    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    private static ListNode head = null;

    private static ReentrantLock lock = new ReentrantLock(true);

    private static int i = 0;
    /**
     * LRU算法实现-- 维护一个有界链表，越早进来的元素在尾部，
     * 新进的元素先判断是否已在链表中(遍历链表时间复杂度为O(n),后面用Hash表优化),
     * 若没有则分两种情况:
     * ①若链表满了则淘汰最尾部的数据，再插入头部
     * ②若没满，则直接插入头部
     * 若在链表中，则删除数据原节点，在头部新增节点
     *
     * @param data
     */
    public void LRUAlgorithm(int data) {
        // 链表缓存是否已满的标志
        boolean capacityFlag = false;
        // 遍历链表若存在data，则删除原节点，并插入新节点
        if(isExitNode(data)){
             removeNode(data);
             insertHead(data);
        } else {
            //若不存在，则判断缓存链表是否满了，若满了则删除尾部数据
            if(capacityFlag){
                removeLastNode();
                insertHead(data);
            }else {
                insertHead(data);
            }
        }

    }

    /**
     * 判断data是否在链表中，返回boolean
     * @param data
     * @return
     */
    private boolean isExitNode(int data) {
        if (head == null)
            return false;
        ListNode root = head;
        while (root != null) {
            if (root.val == data) {
                return true;
            } else {
                root = root.next;
            }
        }
        return false;
    }

    /**
     * 删除val为data的节点
     * @param data
     */
    private void removeNode(int data) {
        if(head == null)
            return;
        //用root指向head指向的链表，代替head来遍历
        ListNode root = head;
        while(root !=null && root.val!=data){
            root = root.next;
        }
        if(root != null) {
            if(root.next!=null) {
                root.next = root.next.next;
            }else {
                head = head.next;
            }
        }
    }

    /**
     * 删除尾部节点
     */
    private void removeLastNode(){
          if(head==null)
              return;
          ListNode root = head;
          if(root.next.next !=null){
              root = root.next;
          }
          root.next = null;
    }

    /**
     * 新增头节点
     */
    private void insertHead(int val){
       if(head == null)
           head = new ListNode(val);
       ListNode node = new ListNode(val);
       node.next = head;
       head = node;
    }


    private static void testThread(){
        lock.lock();
        try {
            System.out.println("线程："+Thread.currentThread().getName()+"正在执行....");
            i++;
            Thread.sleep(300);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


    }

    public static void main(String[] args) throws InterruptedException {

        ReentrantLock lock = new ReentrantLock();

        Thread n1 = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                try {
                    System.out.println("线程:"+Thread.currentThread().getName()+"正在尝试获取lock...");
                    if(lock.tryLock(200, TimeUnit.MILLISECONDS)){
                        System.out.println("线程:"+Thread.currentThread().getName()+"获取lock成功...");
                        testThread();
                    }else {
                        System.out.println("线程:"+Thread.currentThread().getName()+"获取lock失败...");
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        n1.start();


        Thread n2 = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                try {
                    System.out.println("线程:"+Thread.currentThread().getName()+"正在尝试获取lock...");
                    if(lock.tryLock(200, TimeUnit.MILLISECONDS)){
                        System.out.println("线程:"+Thread.currentThread().getName()+"获取lock成功...");
                        testThread();
                    }else {
                        System.out.println("线程:"+Thread.currentThread().getName()+"获取lock失败...");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread n3 = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                try {
                    System.out.println("线程:"+Thread.currentThread().getName()+"正在尝试获取lock...");
                    if(lock.tryLock(200, TimeUnit.MILLISECONDS)){
                        System.out.println("线程:"+Thread.currentThread().getName()+"获取lock成功...");
                        testThread();
                    }else {
                        System.out.println("线程:"+Thread.currentThread().getName()+"获取lock失败...");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        n2.start();
        n3.start();
        n1.join();
        n2.join();
        n3.join();



        System.out.println("i:"+i);

    }
}
