package com.service.impl;

import com.dao.CustomerMapper;
import com.pojo.Customer;
import com.service.CustmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustmerTestServiceImpl implements CustmerService {

    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public int insert(Customer customer) {
        return customerMapper.insert(customer);
    }

    @Override
    public Customer findbyUserName(String userName) {
        return customerMapper.findByUserName(userName);
    }
}
