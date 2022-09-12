package com.seamoon.pjt.springcoreprinciple.order;

import com.seamoon.pjt.springcoreprinciple.core.AppConfig;
import com.seamoon.pjt.springcoreprinciple.member.Grade;
import com.seamoon.pjt.springcoreprinciple.member.Member;
import com.seamoon.pjt.springcoreprinciple.member.MemberService;
import com.seamoon.pjt.springcoreprinciple.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {

        //given
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        //when
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }

}