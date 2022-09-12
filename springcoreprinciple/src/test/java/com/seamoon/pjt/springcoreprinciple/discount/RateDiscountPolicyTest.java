package com.seamoon.pjt.springcoreprinciple.discount;

import com.seamoon.pjt.springcoreprinciple.member.Grade;
import com.seamoon.pjt.springcoreprinciple.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적요오디어야 한다.")
    void vip_o() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertEquals(1000, discount);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야한다.")
    void vip_x() {
        //given
        Member member = new Member(1L, "memberA", Grade.BASIC);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertEquals(100, discount);
    }
}