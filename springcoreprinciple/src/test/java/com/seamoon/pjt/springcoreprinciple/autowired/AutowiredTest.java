package com.seamoon.pjt.springcoreprinciple.autowired;

import com.seamoon.pjt.springcoreprinciple.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {
        //호출 시 에러 발생
        @Autowired(required = true)
        public void setNoBean1(Member member) {
            System.out.println("member = " + member);
        }
    }

    static class TestNullable {
        //Nullable
        @Autowired
        public void setNoBean2(@Nullable Member member) {
            System.out.println("setNoBean2 - member = " + member);
        }
    }

    static class TestOptional {
        //Optional
        @Autowired
        public void setNoBean3(Optional<Member> member) {
            System.out.println("setNoBean3 - member = " + member);
        }
    }

    @Test
    @DisplayName("required true")
    void autowiredOption() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(TestBean.class);
    }

    @Test
    @DisplayName("Nullable")
    void autowiredNullable() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(TestNullable.class);
    }

    @Test
    @DisplayName("Optional.empty")
    void autowiredOptional() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(TestOptional.class);
    }
}
