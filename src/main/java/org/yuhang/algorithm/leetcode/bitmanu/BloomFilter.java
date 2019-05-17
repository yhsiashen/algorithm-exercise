package org.yuhang.algorithm.leetcode.bitmanu;

/**
 * 布隆过滤器实现
 */
public class BloomFilter {

    int[] bits;
    int size;
    static final int DEFAUL_SIZE = (int)Math.pow(10,8); //默认存储空间1亿bit

    public BloomFilter(int capacity){
        this.size = capacity/32+1;
        bits = new int[size];
    }

    public BloomFilter(){
        this.size = DEFAUL_SIZE;
        bits = new int[size];
    }

    /**
     * 想布隆过滤器中添加元素
     * @param val
     */
    public void add(int val){
       // 引入多个hash函数对val进行hash运算,hash函数越多,冲突可能性越小
       int hash1 = hash1(val);
       int hash2 = hash2(val);
       int hash3 = hash3(val);
       // 将这些hash值分别找到在bit数组中存储的位置，标识为1
       int index1 = (hash1 >> 5) +1;
       int index2 = (hash2 >> 5) +1;
       int index3 = (hash3 >> 5) +1;
       bits[index1] |= 1 << (val % 32);
       bits[index2] |= 1 << (val % 32);
       bits[index3] |= 1 << (val % 32);
    }

    /**
     * 判断val是否存在在bloomfilter中,true为存在,false不存在
     * @param val
     * @return
     */
    public boolean isExist(int val){
        // 引入多个hash函数对val进行hash运算,hash函数越多,冲突可能性越小
        int hash1 = hash1(val);
        int hash2 = hash2(val);
        int hash3 = hash3(val);
        // 判断这些hash值应标识的位置是否已经有1了,若不都是1,则该val一定不存在,若都是1,则大概率存在(可能有小概率的hash冲突)
        int index1 = (val >> 5) +1;
        int index2 = (val >> 5) +1;
        int index3 = (val >> 5) +1;
        int valbit1 = 1 << hash1 % 32;
        int valbit2 = 1 << hash2 % 32;
        int valbit3 = 1 << hash3 % 32;
        return (bits[index1] & valbit1) == 1 && (bits[index2] & valbit2) == 1
                   && (bits[index3] & valbit3) == 1;
    }

    /**
     * hash算法
     * @param val
     * @return
     */
    private int hash3(int val) {
        //...
        return 0;
    }

    /**
     * hash算法
     * @param val
     * @return
     */
    private int hash2(int val) {
        //...
        return 0;
    }

    /**
     * hash算法
     * @param val
     * @return
     */
    private int hash1(int val) {
        //...
        return 0;
    }


}
