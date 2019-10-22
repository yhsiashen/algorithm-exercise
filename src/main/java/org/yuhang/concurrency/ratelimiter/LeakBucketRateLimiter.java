package org.yuhang.concurrency.ratelimiter;


/**
 * 漏桶限流
 */
public class LeakBucketRateLimiter {

    /**漏桶大小 */
    private final int capacity;

    /**漏桶流出速率,服务响应时间 */
    private int rate;

    /**桶中累计的请求数 */
    private int curreq;

    /**初始时间 */
    private long time = System.currentTimeMillis();


    public LeakBucketRateLimiter(int capacity, int rate){
        if(capacity <= 0){
            throw new RuntimeException("capacity must be positive number");
        }
        this.capacity = capacity;
        this.rate = rate;
    }

    /**
     * 是否限流
     * @param permits 一次请求数
     * @return
     */
    public boolean acquire(int permits){
       if(permits <= 0) throw new RuntimeException();
       long curTime = System.currentTimeMillis();
       int remain  = Math.max(0,(int)(curTime-time) * rate);//桶中剩余的请求数
       if(permits+curreq < capacity-remain){ //超过空闲容量返回获取失败
           curreq+=permits;
           return true;
       }else{
           return false;
       }
    }






}
