package org.yuhang.algorithm.leetcode.hash;


/**
 * 基于链表法解决hash冲突的散列表(不扩容,链表可无限增加)
 */
public class HashMapImpl<K,V> {

    /** 数组存Entry */
    private Entry<K,V>[] elements;

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
        if(value==null){
            throw new Exception("value must not be null!");
        }
        //先求hash值的绝对值，然后对数组长度取模
        int hash = (hash(key) & 0x7FFFFFFF)% size();
        if(elements[hash] == null){
            elements[hash]= new Entry<K,V>(key,value);
        }else{
            //若此槽位已被占用，则从头结点开始遍历，添加或更新结点值,更新完直接退出
            Entry<K,V> headEntry = elements[hash];
            while (headEntry.nextEntry!=null){
                if(headEntry.key.equals(key)){
                    headEntry.value = value;
                    return;
                }
                headEntry = headEntry.nextEntry;
            }
            //判断尾节点key值与key是否一致，不一致则在后面加节点
            if(headEntry.key.equals(key)){
                headEntry.value = value;
            }else{
                headEntry.nextEntry = new Entry(key,value);
            }
        }
    }


    public V get(K key)  {
        int hash = (hash(key) & 0x7FFFFFFF)% size();
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
     * 求key的hash值
     * @param key
     * @return
     */
    private int hash(K key){
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
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
//          HashMap<String,String> map = new HashMap<>();
//          map.put("user_id","123");
//          hashMap.put("user_id","123");
//          hashMap.put("xiaoming","234");
//          hashMap.put("123","sha");
//          hashMap.put("yuhang","999");
//          hashMap.put("ajh","111");
//          hashMap.put("qwuh1","22");
//          System.out.println(hashMap.get("yuhang"));






    }
}
