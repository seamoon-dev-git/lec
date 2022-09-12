package com.seamoon.pjt.springcoreprinciple.order;

import com.seamoon.pjt.springcoreprinciple.discount.DiscountPolicy;
import com.seamoon.pjt.springcoreprinciple.discount.FixDiscountPolicy;
import com.seamoon.pjt.springcoreprinciple.member.Member;
import com.seamoon.pjt.springcoreprinciple.member.MemberRepository;
import com.seamoon.pjt.springcoreprinciple.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //싱글톤 테스트를 위한 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }
}
