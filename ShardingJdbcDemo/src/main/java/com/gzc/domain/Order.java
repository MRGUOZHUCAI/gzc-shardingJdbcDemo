package com.gzc.domain;


/**
 * @author YCKJ0750
 * @date 2018/9/5 16:59
 */

public class Order {

    private Long orderId;

    private Long userId;

    public Order(){}

    public Order(Long orderId, Long userId){
        this.orderId = orderId;
        this.userId = userId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
