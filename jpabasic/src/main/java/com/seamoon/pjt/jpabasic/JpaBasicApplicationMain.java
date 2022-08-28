package com.seamoon.pjt.jpabasic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaBasicApplicationMain {
    public static void main(String[] args) {

        //EntityManagerFactory 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        em.close();
        emf.close();
    }
}
