package org.yuhang.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * 支持动态扩容的数组
 */
public class Array<E> {
    //数组元素
    private Object[] elementData;
    //空数组
    private final static Object[] EMPTY_ELEMENTDATA = {};
    //数组大小
    private int size;
    //默认大小
    private static final int DEFAULT_CAPACITY = 16;

    public Array(){
        this.elementData = EMPTY_ELEMENTDATA;
    }

    public Array(int capacity) {
        if(capacity>0){
            this.elementData = new Object[capacity];
        }else if(capacity==0){
            this.elementData = EMPTY_ELEMENTDATA;
        }else {
            throw  new IllegalArgumentException("Illegal Capacity:"+capacity);
        }
    }

    /**
     * 在index位置添加元素
     *
     * @param element,index
     * @return
     */
    public boolean add(E element, int index) {
        //校验index范围的合法性
        checkIndexRange(index);
        //确保数组容量满足要求，如果小了则扩容为2倍
        ensureCapacity(size+1);
        //在index位置插入element
        System.arraycopy(elementData,index,elementData,index+1,size-index);
        elementData[index] = element;
        size++;
       return false;
    }

    /**
     * 检查index的范围合法性
     * @param index
     */
    private void checkIndexRange(int index){
        if(index<0||index>size){
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * 扩容为原来数组的2倍
     * @param capacity
     */
    private void ensureCapacity(int capacity){
        if(capacity>elementData.length){
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity>>1;
            elementData = Arrays.copyOf(elementData,newCapacity);
        }
    }

}
