package com.gzc.service;

import com.gzc.domain.Order;

import java.util.List;

/**
 * @author YCKJ0750
 * @date 2018/9/13 18:07
 */
public interface OrderService {
    void addOrder(Order order);
    List<Order> getAllOrder();
}
