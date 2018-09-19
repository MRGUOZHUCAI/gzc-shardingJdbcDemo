package com.gzc.service;

import com.gzc.domain.Order;
import com.gzc.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.Name;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author YCKJ0750
 * @date 2018/9/13 18:09
 */
@Service("OrderServiceImp")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Override
    public void addOrder(Order order) {
        orderMapper.insertOrder(order);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderMapper.getAllOrder();
    }
}
