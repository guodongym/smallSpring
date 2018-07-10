package org.litespring.beans.factory;

import org.litespring.beans.BeanDefinition;

/**
 * Bean工厂
 *
 * @author zhaogd
 * @Date 2018/7/9
 */
public interface BeanFactory {

    /**
     * 获取Bean定义
     *
     * @param beanId id
     * @return BeanDefinition
     */
    BeanDefinition getBeanDefinition(String beanId);

    /**
     * 获取Bean实例
     *
     * @param beanId id
     * @return 实例
     */
    Object getBean(String beanId);
}
