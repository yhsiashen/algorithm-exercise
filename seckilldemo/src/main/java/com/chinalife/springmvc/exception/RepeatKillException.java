package com.chinalife.springmvc.exception;

/**
 *重复秒杀异常（运行期异常），应能检测到并避免用户重复秒杀商品
 * Created by chinalife on 2017/1/6.
 */
public class RepeatKillException extends SeckillException {
    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
