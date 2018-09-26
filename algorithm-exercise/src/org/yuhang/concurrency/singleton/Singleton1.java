package org.yuhang.concurrency.singleton;

import org.yuhang.annotation.ThreadUnsafe;

/**四种单例的写法
 * 懒汉模式- 对象第一次使用时new
 *  线程不安全-
 * Created by chinalife on 2018/5/24.
 */
@ThreadUnsafe
public class Singleton1 {

    //私有构造器
    private Singleton1(){

    }
    //单例模式
    private static Singleton1 instance = null;
    //静态的工厂方法
    public static Singleton1 getInstance(){
        if(instance == null){
            instance = new Singleton1();
        }
        return instance;
    }

}
