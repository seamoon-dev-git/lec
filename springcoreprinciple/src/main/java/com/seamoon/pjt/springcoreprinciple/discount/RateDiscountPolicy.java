package com.seamoon.pjt.springcoreprinciple.discount;

import com.seamoon.pjt.springcoreprinciple.member.Grade;
import com.seamoon.pjt.springcoreprinciple.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10; //10% 할인

    @Override
    public int discount(Member member, int price) {

        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }else {
            return 0;
        }
    }
}
