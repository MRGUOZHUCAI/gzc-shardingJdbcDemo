package com.gzc.service;

import com.gzc.mapper.OrderItemsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YCKJ0750
 * @date 2018/9/17 15:24
 */
@Service
public class OrderItemsServiceImpl implements OrderItemsService{

    @Autowired
    private OrderItemsMapper orderItemsMapper;

    @Override
    public Integer createTItemsIfNotExistsTable() {
        return orderItemsMapper.createTItemsIfNotExistsTable();
    }
}
