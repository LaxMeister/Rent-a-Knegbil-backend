package com.lax.carrental.controller;


import com.lax.carrental.entity.Customer;
import com.lax.carrental.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    // Listar alla kunder
    @GetMapping("/customers")
    public List<Customer> customers(){
        return customerService.customers();
    }

    // Listar specifik kund
    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable long id){
        return customerService.findCustomer(id);
    }
}
