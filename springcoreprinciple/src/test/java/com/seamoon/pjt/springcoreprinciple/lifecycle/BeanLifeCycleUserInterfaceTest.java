package com.seamoon.pjt.springcoreprinciple.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleUserInterfaceTest {

    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac
                = new AnnotationConfigApplicationContext(LifeCycleUserInterfaceConfig.class);
        NetworkClientUserInterface client
                = ac.getBean(NetworkClientUserInterface.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleUserInterfaceConfig {

        @Bean
        public NetworkClientUserInterface networkClientUserInterface() {
            NetworkClientUserInterface networkClientUserInterface
                    = new NetworkClientUserInterface();
            networkClientUserInterface.setUrl("http://seamoon-dev");
            return networkClientUserInterface;
        }

    }

}
