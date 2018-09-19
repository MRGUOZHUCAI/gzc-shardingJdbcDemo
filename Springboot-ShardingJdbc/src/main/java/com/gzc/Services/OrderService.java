package com.gzc.Services;

import com.gzc.domain.Order;
import com.gzc.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author YCKJ0750
 * @date 2018/9/13 10:35
 */
@Service
public class OrderService {

    @Resource
    private OrderRepository orderRepository;

    public void save(Order order){
        orderRepository.save(order);
    }

}
