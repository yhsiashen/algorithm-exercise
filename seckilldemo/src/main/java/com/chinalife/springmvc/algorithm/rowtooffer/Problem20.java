package com.chinalife.springmvc.algorithm.rowtooffer;

import java.util.Arrays;

/** 实现包含min函数的栈
 * Created by chinalife on 2018/5/13.
 */
public class Problem20 {

    //栈容量
    public static final int SIZE = 256;

    //元素数组
    public int[] element;

    //排序暂存的元素数组
    public int[] sortelement;

    //指针
    public int flag;

    public Problem20(){
        this(64);
    }
    public Problem20(int initialCapacity){
        if(initialCapacity<0)
            throw new IllegalArgumentException("initialCapacity value is zore");
        this.element = new int[initialCapacity];
    }


    public void push(int node) {
        if(flag==0)
            element[flag]=node;
        flag++;
        element[flag] = node;

    }

    public void pop() {
        element[flag] = 0;
        flag--;
    }

    public int top() {
        return element[flag];
    }

    public int min() {
        sortelement = new int[flag+1];
        for(int i=0;i<=flag;i++){
            sortelement[i] = element[i];
        }
        Arrays.sort(sortelement);
        return sortelement[0];
    }


    public static void main(String[] args) {
        Problem20 p = new Problem20();
        p.push(1);
        p.push(3);
        p.push(8);
        p.push(5);
        p.push(4);
        System.out.println(p.min());
    }
}
