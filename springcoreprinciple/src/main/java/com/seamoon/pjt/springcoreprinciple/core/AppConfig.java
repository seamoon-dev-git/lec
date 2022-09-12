package com.seamoon.pjt.springcoreprinciple.core;

import com.seamoon.pjt.springcoreprinciple.discount.DiscountPolicy;
import com.seamoon.pjt.springcoreprinciple.discount.FixDiscountPolicy;
import com.seamoon.pjt.springcoreprinciple.discount.RateDiscountPolicy;
import com.seamoon.pjt.springcoreprinciple.member.MemberRepository;
import com.seamoon.pjt.springcoreprinciple.member.MemberService;
import com.seamoon.pjt.springcoreprinciple.member.MemberServiceImpl;
import com.seamoon.pjt.springcoreprinciple.member.MemoryMemberRepository;
import com.seamoon.pjt.springcoreprinciple.order.OrderService;
import com.seamoon.pjt.springcoreprinciple.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        System.out.println("call AppConfig.discountPolicy");
        return new RateDiscountPolicy();
    }
}
