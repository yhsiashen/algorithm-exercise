package org.yuhang.algorithm.leetcode.bitmanu;

/**
 * 位图实现
 */
public class BitMap {

    int[] bits;
    int size;

    public BitMap(int capacity) {
        size = capacity/32+1;//bitmap容量为capacity,代表能存储的数据范围为0~capacity
        bits = new int[size];//如整型的最大值为2^32-1,即约42.9亿，需42.9亿个bit位来存储
    }

    /**
     * 将数字插入bitmap中
     * @param val
     */
    public void addBitMap(int val){
        int index = val / 32 +1; //数字应该存储的数组位置
        bits[index] |= 1 << val % 32; //数字应存储的bit位置,与之前的数字做或运算
    }

    /**
     * 判断数字是否存在在bitmap中
     * @param val
     * @return
     */
    public boolean isExist(int val){
        int index = val / 32+1;
        int valbit = 1 << val % 32;
        return (bits[index] & valbit) != 0; //新的bit值和原有bit值想与,若为0则说明不存在,否则存在
    }
}
