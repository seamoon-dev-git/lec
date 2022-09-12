package com.seamoon.pjt.springcoreprinciple.discount;

import com.seamoon.pjt.springcoreprinciple.member.Member;

public interface DiscountPolicy {

    /**
     *
     * @param member
     * @param price
     * @return int 할인 대상 금액
     */
    int discount(Member member, int price);

}
