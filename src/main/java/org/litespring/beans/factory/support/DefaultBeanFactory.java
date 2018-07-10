package org.litespring.beans.factory.support;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.litespring.beans.BeanDefinition;
import org.litespring.beans.factory.BeanCreationException;
import org.litespring.beans.factory.BeanDefinitionStoreException;
import org.litespring.beans.factory.BeanFactory;
import org.litespring.util.ClassUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Bean工厂的默认实现
 *
 * @author zhaogd
 * @Date 2018/7/9
 */
public class DefaultBeanFactory implements BeanFactory {

    private static final String ID_ATTRIBUTE = "id";
    private static final String CLASS_ATTRIBUTE = "class";

    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(64);

    public DefaultBeanFactory(String configFile) {
        loadBeanDefinition(configFile);
    }

    @Override
    public BeanDefinition getBeanDefinition(String petstore) {
        return beanDefinitionMap.get(petstore);
    }

    @Override
    public Object getBean(String beanId) {
        final BeanDefinition beanDefinition = this.getBeanDefinition(beanId);
        if (beanDefinition == null) {
            throw new BeanCreationException("BeanDefinition does not exists");
        }

        final ClassLoader classLoader = ClassUtils.getDefaultClassLoader();
        final String beanClassName = beanDefinition.getBeanClassName();
        try {
            final Class<?> aClass = classLoader.loadClass(beanClassName);
            return aClass.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new BeanCreationException("create bean for " + beanClassName + " failed", e);
        }
    }

    /**
     * 加载Bean定义
     *
     * @param configFile 配置文件
     */
    private void loadBeanDefinition(String configFile) {
        // 获取classLoader然后获取资源文件流
        final ClassLoader classLoader = ClassUtils.getDefaultClassLoader();
        final InputStream inputStream = classLoader.getResourceAsStream(configFile);

        // 使用dom4j解析xml
        final SAXReader saxReader = new SAXReader();
        try {
            final Document document = saxReader.read(inputStream);
            final Element rootElement = document.getRootElement();

            for (Iterator it = rootElement.elementIterator(); it.hasNext(); ) {
                Element element = (Element) it.next();
                final String id = element.attributeValue(ID_ATTRIBUTE);
                final String className = element.attributeValue(CLASS_ATTRIBUTE);
                BeanDefinition beanDefinition = new GenericBeanDefinition(id, className);
                beanDefinitionMap.put(id, beanDefinition);
            }

        } catch (DocumentException e) {
            throw new BeanDefinitionStoreException("IOException parsing XML document", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
