package com.seamoon.pjt.springcoreprinciple.singleton;

public class StatelessService {

    //private int price; //상태를 유지하는 필드

    public int order(String name, int price) {
        System.out.println("name = " + name + ", price = " + price);
        //this.price = privce; //여기가 문제!!!
        return price;
    }

//    public int getPrice() {
//        return price();
//    }

}
