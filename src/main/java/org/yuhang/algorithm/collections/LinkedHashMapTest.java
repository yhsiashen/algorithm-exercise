package org.yuhang.algorithm.collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {
    /**
     * 继承LinkedHashMap实现LRU缓存队列
     * @param <K>
     * @param <V>
     */
    static class LRUImpl<K,V> extends LinkedHashMap<K,V>{
        private static final int MAX_CAPACITY = 3;

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size()>MAX_CAPACITY;
        }
        LRUImpl(){
            super(MAX_CAPACITY+1,0.75f,true);
        }
    }



    public static void main(String[] args) {
        LRUImpl<String,String> map = new LRUImpl<>();
        map.put("11","a");
        map.put("22","b");
        map.put("33","c");
        map.put("44","d");
        System.out.println(map.keySet());
        map.get("22");
        System.out.println(map.keySet());

    }




}
