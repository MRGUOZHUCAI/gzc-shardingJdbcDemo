package com.gzc.repository;

import com.gzc.domain.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author YCKJ0750
 * @date 2018/9/5 17:04
 */
//@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {


}
