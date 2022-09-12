package com.seamoon.pjt.springcoreprinciple.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleUseBeanTest {

    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac
                = new AnnotationConfigApplicationContext(LifeCycleUseBeanConfig.class);
        NetworkClientUseBean client
                = ac.getBean(NetworkClientUseBean.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleUseBeanConfig {

        @Bean(initMethod = "init", destroyMethod = "close")
        public NetworkClientUseBean networkClientUseBean() {
            NetworkClientUseBean networkClientUseBean
                    = new NetworkClientUseBean();
            networkClientUseBean.setUrl("http://seamoon-dev");
            return networkClientUseBean;
        }

    }
}
