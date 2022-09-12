package com.seamoon.pjt.jpabasic.basic;

import com.seamoon.pjt.jpabasic.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * 회원 수정 예시
 */
public class MemberUpdateMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member findMember = em.find(Member.class, 1L);

            findMember.setName("HelloJPA");

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}
