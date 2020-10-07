package com.lax.carrental.service;

import com.lax.carrental.dao.CustomerRepo;
import com.lax.carrental.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    public List<Customer> customers() {
        return customerRepo.findAll();
    }

    public Customer findCustomer(long id) {
        Customer customer = customerRepo.findById(id);
        return customer;
    }



}
