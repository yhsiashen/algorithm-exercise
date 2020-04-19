package org.yuhang.algorithm.leetcode.design;

import java.util.*;

/**
 * 设计一个常数时间内插入、删除、获取随机元素的数据结构 LC380
 * 常数时间想到HashMap，常数随机获取元素想到ArrayList，常数时间删除元素需删除ArrayList的最后一个元素
 */
public class RandomizedSet {

    Map<Integer,Integer> map;//存数字和在list中的索引位置的关系

    ArrayList<Integer> list;

    Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))return false;
        list.add(val);
        map.put(val, list.size()-1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int index = map.get(val);//要删除的元素在list中的索引
        int lastEle = list.get(list.size()-1);
        list.set(index,lastEle);//将index位置set最后一个元素，相当于删除了val
        map.put(lastEle,index);//更新lastEle的索引位置
        list.remove(list.size()-1);//将list的最后一个元素删除
        map.remove(val);//删除map中的索引
        return true;

    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));//利用ArrayList随机访问元素的特性返回一个随机索引位置的元素
    }
}
