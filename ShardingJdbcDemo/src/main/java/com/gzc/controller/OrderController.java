package com.gzc.controller;

import com.gzc.domain.Order;
import com.gzc.service.OrderItemsService;
import com.gzc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author YCKJ0750
 * @date 2018/9/13 18:49
 * @参考：
 * https://www.cnblogs.com/mr-yang-localhost/p/8280500.html，
 * https://www.jianshu.com/p/74c02a2a89de，
 * http://shardingsphere.io/document/current/cn/manual/sharding-jdbc/usage/sharding/
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource(name = "OrderServiceImp")
    private OrderService orderService;

    @Autowired
    private OrderItemsService orderItemsService;

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/add")
    public String addOrder(){
        for(int i=0;i<10;i++){
            Order order = new Order((long)i,(long)i);
            orderService.addOrder(order);
        }
        for(int j=10;j<20;j++){
            Order order = new Order((long)j,(long)j+1);
            orderService.addOrder(order);
        }
        return "success";
    }

    @RequestMapping("/getAllOrder")
    public List<Order> getAllOrder(){
        List<Order> result = orderService.getAllOrder();
        return result;
    }

    @RequestMapping("/createTest")
    public String createTableTest(){
        Integer result = orderItemsService.createTItemsIfNotExistsTable();
        return result.toString();
    }


}
