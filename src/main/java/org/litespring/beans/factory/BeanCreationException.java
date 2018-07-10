package org.litespring.beans.factory;

import org.litespring.beans.BeansException;

/**
 * bean创建异常
 *
 * @author zhaogd
 * @Date 2018/7/10
 */
public class BeanCreationException extends BeansException {
    private String beanName;

    public BeanCreationException(String msg) {
        super(msg);
    }

    public BeanCreationException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public BeanCreationException(String beanName, String msg) {
        super("Error creating bean with name '" + beanName + "': " + msg);
        this.beanName = beanName;
    }
}
