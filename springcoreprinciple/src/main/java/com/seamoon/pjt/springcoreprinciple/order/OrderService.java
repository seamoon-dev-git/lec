package com.seamoon.pjt.springcoreprinciple.order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);

}
