package com.seamoon.pjt.jpabasic.basic;

import com.seamoon.pjt.jpabasic.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * 회원 단건 조회 예시
 */
public class MemberFindMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            //회원조회
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember.id : " + findMember.getId());
            System.out.println("findMember.name : " + findMember.getName());

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
