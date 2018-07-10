package org.litespring.beans;

/**
 * 和bean相关的异常基类
 *
 * @author zhaogd
 * @Date 2018/7/10
 */
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
}
