package com.lax.carrental.controller;


import com.lax.carrental.entity.Customer;
import com.lax.carrental.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = {"http://127.0.0.1:5501","http://localhost:5001","http://localhost:5002"}, allowCredentials = "true")
public class CustomerController {

    @Autowired
    HttpServletRequest httpServletRequest;

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

    @GetMapping("/currentUser")
    public Customer getCurrentUser (){
        String userName = httpServletRequest.getUserPrincipal().getName();
        return customerService.findCurrentUser(userName);
    }
}
