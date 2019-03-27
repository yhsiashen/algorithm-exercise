package org.yuhang.algorithm.leetcode.hash;


/**
 * 基于链表法解决hash冲突的散列表
 */
public class HashMapImpl<K,V> {

    /** 数组存Entry */
    private Entry[] elements;

    /** 数组容量*/
    private int capacity;

    /** 默认容量*/
    private static int DEFAULT_CAPACITY = 16;

    public HashMapImpl(){
        elements = new Entry[DEFAULT_CAPACITY];
        capacity =  DEFAULT_CAPACITY;
    }

    public int size(){
        return this.capacity;
    }

    public void put(K key,V value) throws Exception {
        if(key==null){
            throw new Exception("key must not be null!");
        }

        int hash = hash(key);
        if(elements[hash] == null){
            elements[hash]= new Entry<K,V>(key,value);
        }else{
            //若此槽位已被占用，则从头结点开始遍历，添加或更新结点值
            Entry<K,V> headEntry = elements[hash];
            while (headEntry!=null){
                if(headEntry.key.equals(key)){
                    headEntry.value = value;
                    break;
                }
                headEntry = headEntry.nextEntry;
            }
            //若遍历完还没找到相同key的结点，则在队尾加结点
            if(headEntry==null)
                headEntry = new Entry(key,value);

        }
    }


    public V get(K key) throws Exception {
        if(key==null){
            throw new Exception("key must not be null!");
        }

        int hash = hash(key);
        if(elements[hash]==null){
            return null;
        }else{
            //遍历槽位的链表，找到key相同的entry
            Entry<K,V> headEntry = elements[hash];
            while (headEntry!=null){
                if(headEntry.key.equals(key)){
                    return headEntry.value;
                }
                headEntry = headEntry.nextEntry;
            }
            //若遍历没找到，则返回null
            return null;
        }
    }


    /**
     * 求key的hash值,对数组长度取模
     * @param key
     * @return
     */
    private int hash(K key){
        return key.hashCode()%size();
    }


    private class Entry<K,V>{
        private K key;
        private V value;
        private Entry nextEntry;

        public Entry(K key,V value){
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
          HashMapImpl<String,String> hashMap = new HashMapImpl<>();
//          hashMap.put("yuhang","123");
//          hashMap.put("xiaoming","234");
//          hashMap.put("yuhang","999");
//        System.out.println(hashMap.get("yuhang"));
        System.out.println("yuhang".hashCode()^ ("yuhang".hashCode() >>> 16));




    }
}
