package com.chinalife.springmvc.exception;

/**
 * 秒杀相关业务异常
 * Created by chinalife on 2017/1/6.
 */
public class SeckillException extends RuntimeException {
    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
