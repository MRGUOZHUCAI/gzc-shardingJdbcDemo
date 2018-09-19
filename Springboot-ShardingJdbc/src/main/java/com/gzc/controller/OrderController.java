package com.gzc.controller;

import com.gzc.Services.OrderService;
import com.gzc.domain.Order;
import com.gzc.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author YCKJ0750
 * @date 2018/9/5 17:41
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/orders")
    public String add(){
        for(int i = 0;i<10;i++){
            Order order =  new Order((long)i,(long)i);
            orderService.save(order);
        }
        for(int j=10;j<20;j++){
            Order order =  new Order((long)j+1,(long)j);
            orderService.save(order);
        }
        return  "success";
    }

/*    @RequestMapping("/order")
    public Iterable<Order> queryAll(){
        return orderRepository.findAll();
    }*/

}
