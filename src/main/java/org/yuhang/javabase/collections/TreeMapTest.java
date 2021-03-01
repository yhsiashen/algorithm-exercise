package org.yuhang.javabase.collections;

import java.util.TreeMap;

/**
 * TreeMap:按key排序的Map,底层用红黑树实现
 */
public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap<Integer,Object> map = new TreeMap<>();
        map.put(2,"2string");
        map.put(9,"9string");
        map.put(0,"0string");
        map.put(1,"1string");
        map.put(5,"5string");
        for(int key:map.keySet()){
            System.out.println(key);
        }
        System.out.println("end");
    }
}
