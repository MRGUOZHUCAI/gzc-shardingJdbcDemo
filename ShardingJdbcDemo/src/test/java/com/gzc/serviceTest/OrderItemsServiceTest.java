package com.gzc.serviceTest;

import com.gzc.domain.Order;
import com.gzc.service.OrderItemsService;
import com.gzc.service.OrderService;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author YCKJ0750
 * @date 2018/9/17 15:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderItemsServiceTest {

    @Autowired
    private OrderItemsService orderItemsService;

    @Autowired
    private OrderService orderService;

    @Test
    public void createTable(){
        int result = orderItemsService.createTItemsIfNotExistsTable();
        assertEquals(4,result);
    }

    @Test
    public void getAllorderTest(){
        List<Order> result = orderService.getAllOrder();
        System.out.println(result);
    }




}
