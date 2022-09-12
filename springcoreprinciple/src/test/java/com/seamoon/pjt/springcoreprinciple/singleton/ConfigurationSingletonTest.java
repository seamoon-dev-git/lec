package com.seamoon.pjt.springcoreprinciple.singleton;

import com.seamoon.pjt.springcoreprinciple.core.AppConfig;
import com.seamoon.pjt.springcoreprinciple.member.MemberRepository;
import com.seamoon.pjt.springcoreprinciple.member.MemberServiceImpl;
import com.seamoon.pjt.springcoreprinciple.order.OrderServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac
                = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService
                = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService
                = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository
                = ac.getBean("memberRepository", MemberRepository.class);

        //모두 같은 인스턴스를 참고하고 있다.
        System.out.println("memberSerive -> memberRepository : " + memberService.getMemberRepository());
        System.out.println("orderService -> memberRepository : " + orderService.getMemberRepository());
        System.out.println("memberRepository : " + memberRepository);

        //모두 같은 인스턴스를 참고하고 있다.
        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }

    @Test
    @DisplayName("AppConfig의 클래스타입을 확인")
    void configurationDeep() {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(AppConfig.class);

        //AppConfig 도 스프링 빈으로 등록한다.
        AppConfig bean = applicationContext.getBean(AppConfig.class);

        System.out.println("bean.getClass() = " + bean.getClass());
    }
}
