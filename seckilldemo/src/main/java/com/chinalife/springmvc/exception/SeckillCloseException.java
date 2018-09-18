package com.chinalife.springmvc.exception;

/**
 * 秒杀关闭异常(秒杀已关闭后不能再进行秒杀)
 * Created by chinalife on 2017/1/6.
 */
public class SeckillCloseException extends SeckillException{
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
