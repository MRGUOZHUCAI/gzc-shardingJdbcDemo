package com.gzc.service;

/**
 * @author YCKJ0750
 * @date 2018/9/17 15:24
 */
public interface OrderItemsService {
    /**
     *使用shardinf-JDBC建表，执行后在两个库中都会创建表_0,_1表
     * @return
     */
    Integer createTItemsIfNotExistsTable();
}
