package org.litespring.beans.factory.support;

import org.litespring.beans.BeanDefinition;

/**
 * 通用的Bean定义
 *
 * @author zhaogd
 */
public class GenericBeanDefinition implements BeanDefinition {

    private String id;
    private String beanClassName;

    public GenericBeanDefinition(String id, String beanClassName) {
        this.id = id;
        this.beanClassName = beanClassName;
    }

    @Override
    public String getBeanClassName() {
        return this.beanClassName;
    }
}
