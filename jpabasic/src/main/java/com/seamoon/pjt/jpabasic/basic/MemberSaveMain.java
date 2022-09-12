package com.seamoon.pjt.jpabasic.basic;

import com.seamoon.pjt.jpabasic.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * 회원 저장 예시
 */
public class MemberSaveMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {

            Member member = new Member();
            member.setId(1L);
            member.setName("HelloA");

            //저장
            em.persist(member);

            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
