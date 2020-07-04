package com.atguigu.service.impl;

import com.atguigu.Mapper.CustomerMapper;
import com.atguigu.domain.Customer;
import com.atguigu.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 先查询缓存 在查询数据库
     * @return
     */
    @Override
    public List<Customer> findCustomers() {
        String key = "allcustomer";
        List<Customer> Customers = (List<Customer>) redisTemplate.boundValueOps(key).get();
        if (Customers!=null) {
            System.out.println("从Redis中获取缓存数据="+Customers);
            return Customers;
        }


        List<Customer> list = customerMapper.findAll();
        // 将数据库数据存入到redis中
        if (list != null && list.size()>0) {
            System.out.println("从数据库中获取数据存放到Redis缓存="+list);
            redisTemplate.boundValueOps(key).set(list);
        }

        return list;
    }

    @Override
    public Customer findCustomerById(Integer id) {
        return customerMapper.getOne(id);
    }

    @Override
    public void saveCustomer(Customer c) {
        customerMapper.save(c);
    }

    @Override
    public void updateCustomer(Customer c) {
        customerMapper.save(c);
    }

    @Override
    public void deleteCustomerById(Integer id) {
        customerMapper.deleteById(id);
    }
}
