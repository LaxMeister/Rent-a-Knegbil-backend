package com.lax.carrental.dao;

import com.lax.carrental.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

    Customer findById(long id);
    Customer findByFirstname(String name);
    Customer findByUsername(String username);

}
