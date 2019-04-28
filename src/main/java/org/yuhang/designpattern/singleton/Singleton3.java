package org.yuhang.designpattern.singleton;


/** 懒汉模式优化- 在方法上加锁来实现线程安全，不过可能会造成性能开销
 * Created by chinalife on 2018/5/24.
 */

public class Singleton3 {

    private Singleton3(){

    }

    private volatile static Singleton3 instance = null;

    public synchronized static Singleton3 getInstance(){
        if(instance == null){
                    instance = new Singleton3();
            }
        return instance;

    }
}
