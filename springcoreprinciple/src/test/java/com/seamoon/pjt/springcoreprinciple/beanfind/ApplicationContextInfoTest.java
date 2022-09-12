package com.seamoon.pjt.springcoreprinciple.beanfind;

import com.seamoon.pjt.springcoreprinciple.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext applicationContext
            = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = applicationContext.getBean(beanDefinitionName);
            System.out.println("name : " + beanDefinitionName + " / object : " + bean);
        }

    }

    @Test
    @DisplayName("스프링 빈 또는 외부 라이브러리")
    void findSpringBean() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = applicationContext.getBeanDefinition(beanDefinitionName);
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = applicationContext.getBean(beanDefinitionName);
                System.out.println("name : " + beanDefinitionName + " / object : " + bean);
            }
        }
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = applicationContext.getBeanDefinition(beanDefinitionName);
            if (beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE) {
                Object bean = applicationContext.getBean(beanDefinitionName);
                System.out.println("name : " + beanDefinitionName + " / object : " + bean);
            }
        }
    }
}
