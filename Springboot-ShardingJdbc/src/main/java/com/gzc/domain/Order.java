package com.gzc.domain;


import org.aspectj.weaver.ast.Or;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author YCKJ0750
 * @date 2018/9/5 16:59
 */

@Entity
@Table(name = "t_order")
public class Order {
    @Id
    private Long orderId;

    private Long userId;

    public Order (){}

    public Order(Long orderId,Long userId){
        this.orderId = orderId;
        this.userId = userId;
    }

    @Column(name="order_id")
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Column(name="user_id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
