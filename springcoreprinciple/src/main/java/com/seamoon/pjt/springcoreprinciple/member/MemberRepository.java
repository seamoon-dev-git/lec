package com.seamoon.pjt.springcoreprinciple.member;

public interface MemberRepository {

    //회원 저장
    void save(Member member);

    //회원 조회 - 회원ID 사용
    Member findById(Long memberId);

}
