package org.yuhang.concurrency.ratelimiter;

import com.google.common.util.concurrent.RateLimiter;

/**
 * 令牌桶算法限流器,Google Guava实现
 */
public class GuavaRateLimiter {

    public static void main(String[] args) {
        /**
         * 创建一个限流器，设置每秒放置的令牌数：5个。
         * RateLimiter对象保证1秒内不会给超过5个令牌，并且是固定速率放置，达到平滑输出的效果
         */
        RateLimiter rateLimiter = RateLimiter.create(5);

        while (true){
            //acquire()获取一个令牌，并且返回这个获取这个令牌所需要的时间。如果桶里没有令牌则等待，直到有令牌
            //acquire(N)可以一次性获取多个令牌
            System.out.println(rateLimiter.acquire(10));
        }

    }
}
