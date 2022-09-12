package com.seamoon.pjt.springcoreprinciple.discount;

import com.seamoon.pjt.springcoreprinciple.member.Grade;
import com.seamoon.pjt.springcoreprinciple.member.Member;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000; //1000원 할인

    @Override
    public int discount(Member member, int price) {

        //VIP 등급이면 1000원 할인, 그렇지 않으면 할인 없음
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }else {
            return 0;
        }
    }
}
