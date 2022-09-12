package com.seamoon.pjt.springcoreprinciple.order;

import com.seamoon.pjt.springcoreprinciple.core.AppConfig;
import com.seamoon.pjt.springcoreprinciple.member.Grade;
import com.seamoon.pjt.springcoreprinciple.member.Member;
import com.seamoon.pjt.springcoreprinciple.member.MemberService;
import com.seamoon.pjt.springcoreprinciple.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService
                = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService
                = applicationContext.getBean("orderService", OrderService.class);

        //먼저 회원 저장
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order : " + order);
        System.out.println("calculatePrice : " + order.calculatePrice());
    }
}
