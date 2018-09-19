package com.gzc.mapper;

import com.gzc.domain.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author YCKJ0750
 * @date 2018/9/13 17:28
 */
@Mapper
public interface OrderMapper {

    void insertOrder(Order order);

    List<Order> getAllOrder();

}
