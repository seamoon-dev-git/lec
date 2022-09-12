package com.seamoon.pjt.springcoreprinciple.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleUseAnnotationTest {

    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac
                = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClientUseAnnotation client = ac.getBean(NetworkClientUseAnnotation.class);
        ac.close(); // 스프링 컨테이너를 종료. ConfigurableApplicationContext 필요
    }


    @Configuration
    static class LifeCycleConfig {
        @Bean
        public NetworkClientUseAnnotation networkClient() {
            NetworkClientUseAnnotation networkClient = new NetworkClientUseAnnotation();
            networkClient.setUrl("http://seamoon-spring.dev");
            return networkClient;
        }
    }

}
