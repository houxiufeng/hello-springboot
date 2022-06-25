package com.example.hellospringboot.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SpringContextUtil3 {
    private static ApplicationContext applicationContext;

    public SpringContextUtil3(ApplicationContext applicationContext) {
        SpringContextUtil3.applicationContext =applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static <T> T getBean(String name) {
        return (T) applicationContext.getBean(name);
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        return applicationContext.getBean(name, clazz);
    }

    public static <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getApplicationContext().getBeansOfType(type);
    }

    public static void publish(ApplicationEvent event) {
        getApplicationContext().publishEvent(event);
    }


}
