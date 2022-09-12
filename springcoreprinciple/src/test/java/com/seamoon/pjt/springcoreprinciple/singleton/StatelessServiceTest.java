package com.seamoon.pjt.springcoreprinciple.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;

public class StatelessServiceTest {

    @Test
    void statelessServiceTest() {

        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(TestConfig.class);

        StatelessService statelessService1
                = applicationContext.getBean("statelessService", StatelessService.class);
        StatelessService statelessService2
                = applicationContext.getBean("statelessService", StatelessService.class);

        //ThreadA : A 사용자 10000원 주문
        int orderAprice = statelessService1.order("userA", 10000);

        //ThreadB : B 사용자 20000원 주문
        int orderBprice = statelessService2.order("userB", 20000);

        //ThreadA : 사용자A 주문 금액 조회
        System.out.println("price = " + orderAprice);

        assertThat(orderAprice).isEqualTo(10000);
    }

    static class TestConfig {

        @Bean
        public StatelessService statelessService() {
            return new StatelessService();
        }

    }

}
