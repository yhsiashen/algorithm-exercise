package org.yuhang.concurrency.singleton;

import org.yuhang.annotation.ThreadSafe;

/** 饿汉模式- 在类加载时初始化完毕(类的静态成员变量 new了一个对象)
 *  在私有构造函数中如果初始化了很多资源，但这个类又没被用到，可能会造成资源浪费，性能开销增加
 *  线程安全
 * Created by chinalife on 2018/5/24.
 */
@ThreadSafe
public class Singleton2 {

    private Singleton2(){

    }

    private static Singleton2 instance = new Singleton2();

    public static  Singleton2 getInstance(){
        return instance;
    }

}
