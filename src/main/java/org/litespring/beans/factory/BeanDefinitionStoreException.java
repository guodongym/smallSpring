package org.litespring.beans.factory;

import org.litespring.beans.BeansException;

/**
 * bean定义存储异常
 *
 * @author zhaogd
 * @Date 2018/7/10
 */
public class BeanDefinitionStoreException extends BeansException {

    public BeanDefinitionStoreException(String msg) {
        super(msg);
    }

    public BeanDefinitionStoreException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
}
