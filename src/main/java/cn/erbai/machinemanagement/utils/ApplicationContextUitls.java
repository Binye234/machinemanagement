package cn.erbai.machinemanagement.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @description:取容器中实例工具类
 * @author: boood
 * @time: 2021/12/5 12:50
 */
@Component
public class ApplicationContextUitls implements ApplicationContextAware {
    public static ApplicationContext context;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextUitls.context=applicationContext;
    }

    static public Object getBean(String beanName){
        return context.getBean(beanName);
    }
}
