package com.seamoon.pjt.springcoreprinciple.scan;

import com.seamoon.pjt.springcoreprinciple.AutoAppConfig;
import com.seamoon.pjt.springcoreprinciple.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoAppConfigTest {

    @Test
    @DisplayName("AutoConfig 확인")
    void basicScan() {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = applicationContext.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);

    }

}
