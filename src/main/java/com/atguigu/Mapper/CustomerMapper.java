package com.atguigu.Mapper;

import com.atguigu.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 继承jpa 接口
 */
public interface CustomerMapper extends JpaRepository<Customer,Integer> {
}
