package com.service;


import com.pojo.Customer;
import org.springframework.stereotype.Service;



public interface CustmerService {

    public int insert(Customer customer);

    public Customer findbyUserName(String userName);
}
