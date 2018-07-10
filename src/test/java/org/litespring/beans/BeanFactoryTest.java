package org.litespring.beans;

import org.junit.Assert;
import org.junit.Test;
import org.litespring.beans.factory.BeanCreationException;
import org.litespring.beans.factory.BeanDefinitionStoreException;
import org.litespring.beans.factory.BeanFactory;
import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.service.PetStoreService;

/**
 * Created by IntelliJ IDEA.
 *
 * @author zhaogd
 * @Date 2018/7/9
 */
public class BeanFactoryTest {

    @Test
    public void testGetBean() {
        // 给定一个配置文件获取bean定义
        BeanFactory factory = new DefaultBeanFactory("petstore-v1.xml");
        BeanDefinition definition = factory.getBeanDefinition("petStore");

        Assert.assertEquals("org.litespring.service.PetStoreService", definition.getBeanClassName());

        PetStoreService petstore = (PetStoreService) factory.getBean("petStore");

        Assert.assertNotNull(petstore);
    }

    @Test
    public void testInvalidBean() {
        BeanFactory factory = new DefaultBeanFactory("petstore-v1.xml");
        try {
            factory.getBean("invalidBean");
        } catch (BeanCreationException e) {
            return;
        }
        Assert.fail("expect BeanCreationException ");
    }

    @Test
    public void testInvalidConfigFile() {
        try {
            new DefaultBeanFactory("invalid.xml");
        } catch (BeanDefinitionStoreException e) {
            return;
        }
        Assert.fail("expect BeanDefinitionStoreException ");
    }

}
