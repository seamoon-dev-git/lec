package com.seamoon.pjt.springcoreprinciple.beanfind;

import com.seamoon.pjt.springcoreprinciple.core.AppConfig;
import com.seamoon.pjt.springcoreprinciple.member.MemberService;
import com.seamoon.pjt.springcoreprinciple.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext applicationContext
            = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService
                = applicationContext.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanType() {
        MemberService memberService
                = applicationContext.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void finBeanByName2() {
        MemberServiceImpl memberService
                = applicationContext.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX() {
        Assertions.assertThrows(NoSuchBeanDefinitionException.class, () ->
                applicationContext.getBean("xxx", MemberService.class));
    }
    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX2() {
        MemberService memberService
                = applicationContext.getBean("xxx", MemberService.class);
    }
}
