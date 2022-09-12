package com.seamoon.pjt.jpabasic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaBasicApplicationMain {
    public static void main(String[] args) {

        //EntityManagerFactory 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        //EntityManager 생성
        EntityManager em = emf.createEntityManager();

        //code

        //생성한 것들을 close 해줘야 한다.
        em.close();
        emf.close();
    }
}